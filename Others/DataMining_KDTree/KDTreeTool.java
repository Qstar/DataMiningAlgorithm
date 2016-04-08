package Others.DataMining_KDTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * KD��-kά�ռ�ؼ����ݼ����㷨������
 *
 * @author Qstar
 */
class KDTreeTool {
    // �ռ�ƽ��ķ���
    static final int DIRECTION_X = 0;
    private static final int DIRECTION_Y = 1;

    // ����Ĳ�������������ļ�
    private String filePath;
    // ԭʼ�������ݵ�����
    private ArrayList<Point> totalDatas;
    // KD�����ڵ�
    private TreeNode rootNode;

    KDTreeTool(String filePath){
        this.filePath = filePath;

        readDataFile();
    }

    /**
     * ���ļ��ж�ȡ����
     */
    private void readDataFile(){
        File file = new File(filePath);
        ArrayList<String[]> dataArray = new ArrayList<>();

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            String[] tempArray;
            while ((str = in.readLine()) != null) {
                tempArray = str.split(" ");
                dataArray.add(tempArray);
            }
            in.close();
        } catch (IOException e) {
            e.getStackTrace();
        }

        Point p;
        totalDatas = new ArrayList<>();
        for (String[] array : dataArray) {
            p = new Point(array[0], array[1]);
            totalDatas.add(p);
        }
    }

    /**
     * ����KD��
     */
    TreeNode createKDTree(){
        ArrayList<Point> copyDatas;

        rootNode = new TreeNode();
        // ���ݽڵ㿪ʼʱ����ʾ�Ŀռ�ʱ���޴��
        rootNode.range = new Range();
        copyDatas = (ArrayList<Point>) totalDatas.clone();
        recursiveConstructNode(rootNode, copyDatas);

        return rootNode;
    }

    /**
     * �ݹ����KD���Ĺ���
     *
     * @param node ��ǰ���ڹ���Ľڵ�
     * @param data �ýڵ��Ӧ�����ڴ��������
     */
    private void recursiveConstructNode(TreeNode node, ArrayList<Point> data){
        int direction;
        ArrayList<Point> leftSideData;
        ArrayList<Point> rightSideData;
        Point p;
        TreeNode leftNode;
        TreeNode rightNode;
        Range range;
        Range range2;

        // ������ֵ����ݵ㼯��ֻ��1�����ݣ����ٻ���
        if (data.size() == 1) {
            node.nodeData = data.get(0);
            return;
        }

        // �����ڵ�ǰ�����ݵ㼯���н��зָ���ѡ��
        direction = selectSplitDrc(data);
        // ���ݷ���ȡ����λ������Ϊ����ʸ��
        p = getMiddlePoint(data, direction);

        node.spilt = direction;
        node.nodeData = p;

        leftSideData = getLeftSideData(data, p, direction);
        data.removeAll(leftSideData);
        // ��Ҫȥ������
        data.remove(p);
        rightSideData = data;

        if (leftSideData.size() > 0) {
            leftNode = new TreeNode();
            leftNode.parentNode = node;
            range2 = Range.initLeftRange(p, direction);
            // ��ȡ���ڵ�Ŀռ�ʸ�������н�����������Χ���
            range = node.range.crossOperation(range2);
            leftNode.range = range;

            node.leftNode = leftNode;
            recursiveConstructNode(leftNode, leftSideData);
        }

        if (rightSideData.size() > 0) {
            rightNode = new TreeNode();
            rightNode.parentNode = node;
            range2 = Range.initRightRange(p, direction);
            // ��ȡ���ڵ�Ŀռ�ʸ�������н�����������Χ���
            range = node.range.crossOperation(range2);
            rightNode.range = range;

            node.rightNode = rightNode;
            recursiveConstructNode(rightNode, rightSideData);
        }
    }

    /**
     * �������������ݵ�������
     *
     * @param p ���Ƚ������
     */
    Point searchNearestData(Point p){
        // �ڵ����������ݵ�ľ���
        TreeNode nearestNode;
        // ��ջ��¼�������Ľڵ�
        Stack<TreeNode> stackNodes;

        stackNodes = new Stack<>();
        findedNearestLeafNode(p, rootNode, stackNodes);

        // ȡ��Ҷ�ӽڵ㣬��Ϊ��ǰ�ҵ�������ڵ�
        nearestNode = stackNodes.pop();
        nearestNode = dfsSearchNodes(stackNodes, p, nearestNode);

        return nearestNode.nodeData;
    }

    /**
     * ������ȵķ�ʽ���������Ĳ���
     *
     * @param stack       KD���ڵ�ջ
     * @param desPoint    ���������ݵ�
     * @param nearestNode ��ǰ�ҵ�������ڵ�
     */
    private TreeNode dfsSearchNodes(Stack<TreeNode> stack, Point desPoint,
                                    TreeNode nearestNode){
        // �Ƿ��������ڵ�߽�
        boolean isCollision;
        double minDis;
        double dis;
        TreeNode parentNode;

        // ���ջ�ڽڵ��Ѿ�ȫ�����������������
        if (stack.isEmpty()) {
            return nearestNode;
        }

        // ��ȡ���ڵ�
        parentNode = stack.pop();

        minDis = desPoint.ouDistance(nearestNode.nodeData);
        dis = desPoint.ouDistance(parentNode.nodeData);

        // ����뵱ǰ���ݵ��ĸ��ڵ������̣����������Ľڵ���и���
        if (dis < minDis) {
            minDis = dis;
            nearestNode = parentNode;
        }

        // Ĭ��û����ײ��
        isCollision = false;
        // �ж��Ƿ������˸��ڵ�Ŀռ�ָ���
        if (parentNode.spilt == DIRECTION_X) {
            if (parentNode.nodeData.x > desPoint.x - minDis
                    && parentNode.nodeData.x < desPoint.x + minDis) {
                isCollision = true;
            }
        } else {
            if (parentNode.nodeData.y > desPoint.y - minDis
                    && parentNode.nodeData.y < desPoint.y + minDis) {
                isCollision = true;
            }
        }

        // ������������߽��ˣ����Ҵ˽ڵ�ĺ��ӽڵ㻹δ��ȫ�����꣬����Լ�������
        if (isCollision
                && (!parentNode.leftNode.isVisited || !parentNode.rightNode.isVisited)) {
            TreeNode newNode;
            // �½���ǰ��С�ֲ��ڵ�ջ
            Stack<TreeNode> otherStack = new Stack<>();
            // ��parentNode�������¼���Ѱ��
            findedNearestLeafNode(desPoint, parentNode, otherStack);
            newNode = dfsSearchNodes(otherStack, desPoint, otherStack.pop());

            dis = newNode.nodeData.ouDistance(desPoint);
            if (dis < minDis) {
                nearestNode = newNode;
            }
        }

        // �������ϻ���
        nearestNode = dfsSearchNodes(stack, desPoint, nearestNode);

        return nearestNode;
    }

    /**
     * �ҵ����������ڵ�������Ҷ�ӽڵ�
     *
     * @param p     ���ȽϽڵ�
     * @param node  ��ǰ�������Ľڵ�
     * @param stack �������Ľڵ�ջ
     */
    private void findedNearestLeafNode(Point p, TreeNode node,
                                       Stack<TreeNode> stack){
        // �ָ��
        int splitDic;

        // ���������Ľڵ����ջ��
        stack.push(node);
        // ���Ϊ���ʹ�
        node.isVisited = true;
        // ����˽ڵ�û�����Һ��ӽڵ�˵���Ѿ���Ҷ�ӽڵ���
        if (node.leftNode == null && node.rightNode == null) {
            return;
        }

        splitDic = node.spilt;
        // ѡ��һ�����ϷָΧ�Ľڵ�����ݹ���Ѱ
        if ((splitDic == DIRECTION_X && p.x < node.nodeData.x)
                || (splitDic == DIRECTION_Y && p.y < node.nodeData.y)) {
            if (node.leftNode != null) {
                if (!node.leftNode.isVisited) {
                    findedNearestLeafNode(p, node.leftNode, stack);
                } else {
                    // ������ӽڵ��Ѿ����ʹ����������һ��
                    findedNearestLeafNode(p, node.rightNode, stack);
                }
            }
        } else if ((splitDic == DIRECTION_X && p.x > node.nodeData.x)
                || (splitDic == DIRECTION_Y && p.y > node.nodeData.y)) {
            if (!node.rightNode.isVisited) {
                findedNearestLeafNode(p, node.rightNode, stack);
            } else {
                // ����Һ��ӽڵ��Ѿ����ʹ����������һ��
                findedNearestLeafNode(p, node.leftNode, stack);
            }
        }
    }

    /**
     * ���ݸ��������ݵ�ͨ�����㷴��ѡ��ķָ��
     *
     * @param data ���ֵļ��ϵ㼯��
     */
    private int selectSplitDrc(ArrayList<Point> data){
        int direction;
        double avgX = 0;
        double avgY = 0;
        double varianceX = 0;
        double varianceY = 0;

        for (Point p : data) {
            avgX += p.x;
            avgY += p.y;
        }

        avgX /= data.size();
        avgY /= data.size();

        for (Point p : data) {
            varianceX += (p.x - avgX) * (p.x - avgX);
            varianceY += (p.y - avgY) * (p.y - avgY);
        }

        // �����ķ���
        varianceX /= data.size();
        varianceY /= data.size();

        // ͨ���ȽϷ���Ĵ�С�����ָ��ѡ�񲨶��ϴ�Ľ��л���
        direction = varianceX > varianceY ? DIRECTION_X : DIRECTION_Y;

        return direction;
    }

    /**
     * ��������㷽λ��������ѡ���м�����������
     *
     * @param datas ���ݵ㼯��
     * @param dir   ��������귽��
     */
    private Point getMiddlePoint(ArrayList<Point> datas, int dir){
        int index;
        Point middlePoint;

        index = datas.size() / 2;
        if (dir == DIRECTION_X) {
            Collections.sort(datas, (o1, o2) -> o1.x.compareTo(o2.x));
        } else {
            Collections.sort(datas, (o1, o2) -> o2.y.compareTo(o1.y));
        }

        // ȡ����λ��
        middlePoint = datas.get(index);

        return middlePoint;
    }

    /**
     * ���ݷ���õ�ԭ���ֽڵ㼯���������ݵ�
     *
     * @param data     ԭʼ���ݵ㼯��
     * @param nodeData ����ʸ��
     * @param dir      �ָ��
     */
    private ArrayList<Point> getLeftSideData(ArrayList<Point> data,
                                             Point nodeData, int dir){
        ArrayList<Point> leftSideDatas = new ArrayList<>();

        for (Point p : data) {
            if (dir == DIRECTION_X && p.x < nodeData.x) {
                leftSideDatas.add(p);
            } else if (dir == DIRECTION_Y && p.y < nodeData.y) {
                leftSideDatas.add(p);
            }
        }

        return leftSideDatas;
    }
}
