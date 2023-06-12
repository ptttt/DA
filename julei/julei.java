package cn.jsnu.demo.julei;

import java.util.ArrayList;
import java.util.Random;

import org.algorithm.Kmeans;

public class KmeansTest {
    public static void main(String[] args)

    {
//初始化一个Kmean对象，将k置为10

        Kmeans k=new Kmeans(10);

        ArrayList dataSet=new ArrayList();

        dataSet.add(new float[]{1,2});

        dataSet.add(new float[]{3,3});

        dataSet.add(new float[]{3,4});

        dataSet.add(new float[]{5,6});

        dataSet.add(new float[]{8,9});

        dataSet.add(new float[]{4,5});

        dataSet.add(new float[]{6,4});

        dataSet.add(new float[]{3,9});

        dataSet.add(new float[]{5,9});

        dataSet.add(new float[]{4,2});

        dataSet.add(new float[]{1,9});

        dataSet.add(new float[]{7,8});

//设置原始数据集

        k.setDataSet(dataSet);

//执行算法

        k.execute();

//得到聚类结果

        ArrayList> cluster=k.getCluster();

//查看结果

        for(int i=0;i

        {
            k.printDataArray(cluster.get(i), "cluster["+i+"]");

        }

    }

}



package org.algorithm;

        import java.util.ArrayList;

        import java.util.Random;

public class Kmeans {
    private int k;// 分成多少簇

    private int m;// 迭代次数

    private int dataSetLength;// 数据集元素个数，即数据集的长度

    private ArrayList dataSet;// 数据集链表

    private ArrayList center;// 中心链表

    private ArrayList cluster; // 簇

    private ArrayList jc;// 误差平方和，k越接近dataSetLength，误差越小

    private Random random;

    public void setDataSet(ArrayList dataSet) {
        this.dataSet = dataSet;

    }

    public ArrayList> getCluster() {
        return cluster;

    }

    public Kmeans(int k) {
        if (k <= 0) {
            k = 1;

        }

        this.k = k;

    }

    private void init() {
        m = 0;

        random = new Random();

        if (dataSet == null || dataSet.size() == 0) {
            initDataSet();

        }

        dataSetLength = dataSet.size();

        if (k > dataSetLength) {
            k = dataSetLength;

        }

        center = initCenters();

        cluster = initCluster();

        jc = new ArrayList();

    }

    private void initDataSet() {
        dataSet = new ArrayList();

// 其中{6,3}是一样的，所以长度为15的数据集分成14簇和15簇的误差都为0

        float[][] dataSetArray = new float[][] { { 8, 2 }, { 3, 4 }, { 2, 5

        },

                { 4, 2 }, { 7, 3 }, { 6, 2 }, { 4, 7 }, { 6, 3 }, { 5, 3 },

                { 6, 3 }, { 6, 9 }, { 1, 6 }, { 3, 9 }, { 4, 1 }, { 8, 6 } };

        for (int i = 0; i < dataSetArray.length; i++) {
            dataSet.add(dataSetArray[i]);

        }

    }

    private ArrayList initCenters() {
        ArrayList center = new ArrayList();

        int[] randoms = new int[k];

        boolean flag;

        int temp = random.nextInt(dataSetLength);

        randoms[0] = temp;

        for (int i = 1; i < k; i++) {
            flag = true;

            while (flag) {
                temp = random.nextInt(dataSetLength);

                int j = 0;

// 不清楚for循环导致j无法加1

// for(j=0;j

// {
// if(temp==randoms[j]);

// {
// break;

// }

// }

                while (j < i) {
                    if (temp == randoms[j]) {
                        break;

                    }

                    j++;

                }

                if (j == i) {
                    flag = false;

                }

            }

            randoms[i] = temp;

        }

// 测试随机数生成情况

// for(int i=0;i

// {
// System.out.println("test1:randoms["+i+"]="+randoms[i]);

// }

// System.out.println();

        for (int i = 0; i < k; i++) {
            center.add(dataSet.get(randoms[i]));// 生成初始化中心链表

        }

        return center;

    }

    private ArrayList> initCluster() {
        ArrayList> cluster = new ArrayList>();

        for (int i = 0; i < k; i++) {
            cluster.add(new ArrayList());

        }

        return cluster;

    }

    private float distance(float[] element, float[] center) {
        float distance = 0.0f;

        float x = element[0] - center[0];

        float y = element[1] - center[1];

        float z = x * x + y * y;

        distance = (float) Math.sqrt(z);

        return distance;

    }

    private int minDistance(float[] distance) {
        float minDistance = distance[0];

        int minLocation = 0;

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] < minDistance) {
                minDistance = distance[i];

                minLocation = i;

            } else if (distance[i] == minDistance) // 如果相等，随机返回一个位置

            {
                if (random.nextInt(10) < 5) {
                    minLocation = i;

                }

            }

        }

        return minLocation;

    }

    private void clusterSet() {
        float[] distance = new float[k];

        for (int i = 0; i < dataSetLength; i++) {
            for (int j = 0; j < k; j++) {
                distance[j] = distance(dataSet.get(i), center.get(j));

//

                System.out.println("test2:"+"dataSet["+i+"],center["+j+"],distance="+distance[j]);

            }

            int minLocation = minDistance(distance);

//

            System.out.println("test3:"+"dataSet["+i+"],minLocation="+minLocation);

// System.out.println();

            cluster.get(minLocation).add(dataSet.get(i));//

            核心，将当前元素放到最小距离中心相关的簇中

        }

    }

    private float errorSquare(float[] element, float[] center) {
        float x = element[0] - center[0];

        float y = element[1] - center[1];

        float errSquare = x * x + y * y;

        return errSquare;

    }

    private void countRule() {
        float jcF = 0;

        for (int i = 0; i < cluster.size(); i++) {
            for (int j = 0; j < cluster.get(i).size(); j++) {
                jcF += errorSquare(cluster.get(i).get(j), center.get(i));

            }

        }

        jc.add(jcF);

    }

    private void setNewCenter() {
        for (int i = 0; i < k; i++) {
            int n = cluster.get(i).size();

            if (n != 0) {
                float[] newCenter = { 0, 0 };

                for (int j = 0; j < n; j++) {
                    newCenter[0] += cluster.get(i).get(j)[0];

                    newCenter[1] += cluster.get(i).get(j)[1];

                }

// 设置一个平均值

                newCenter[0] = newCenter[0] / n;

                newCenter[1] = newCenter[1] / n;

                center.set(i, newCenter);

            }

        }

    }

    public void printDataArray(ArrayList dataArray,

                               String dataArrayName) {
        for (int i = 0; i < dataArray.size(); i++) {
            System.out.println("print:" + dataArrayName + "[" + i + "]={"

                    + dataArray.get(i)[0] + "," + dataArray.get(i)[1] + "}");

        }

        System.out.println("===================================");

    }

    private void kmeans() {
        init();

// printDataArray(dataSet,"initDataSet");

// printDataArray(center,"initCenter");

// 循环分组，直到误差不变为止

        while (true) {
            clusterSet();

// for(int i=0;i

// {
// printDataArray(cluster.get(i),"cluster["+i+"]");

// }

            countRule();

// System.out.println("count:"+"jc["+m+"]="+jc.get(m));

// System.out.println();

// 误差不变了，分组完成

            if (m != 0) {
                if (jc.get(m) - jc.get(m - 1) == 0) {
                    break;

                }

            }

            setNewCenter();

// printDataArray(center,"newCenter");

            m++;

            cluster.clear();

            cluster = initCluster();

        }

// System.out.println("note:the times of repeat:m="+m);//输出迭代次数

    }

    public void execute() {
        long startTime = System.currentTimeMillis();

        System.out.println("kmeans begins");

        kmeans();

        long endTime = System.currentTimeMillis();

        System.out.println("kmeans running time=" + (endTime -

                startTime)

                + "ms");

        System.out.println("kmeans ends");

        System.out.println();

    }

}