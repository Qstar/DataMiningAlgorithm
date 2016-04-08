package Others.DataMining_KDTree;

/**
 * �ռ�ʸ������ʾ������Ŀռ䷶Χ
 *
 * @author Qstar
 */
class Range {
    // �߽���߽�
    private double left;
    // �߽��ұ߽�
    private double right;
    // �߽��ϱ߽�
    private double top;
    // �߽��±߽�
    private double bottom;

    Range(){
        this.left = -Integer.MAX_VALUE;
        this.right = Integer.MAX_VALUE;
        this.top = Integer.MAX_VALUE;
        this.bottom = -Integer.MAX_VALUE;
    }

    public Range(int left, int right, int top, int bottom){
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }

    /**
     * ���������ָ��ȷ�����ռ�ʸ��
     *
     * @param p   ����ʸ��
     * @param dir �ָ��
     */
    static Range initLeftRange(Point p, int dir){
        Range range = new Range();

        if (dir == KDTreeTool.DIRECTION_X) {
            range.right = p.x;
        } else {
            range.bottom = p.y;
        }

        return range;
    }

    /**
     * ���������ָ��ȷ���Ҳ�ռ�ʸ��
     *
     * @param p   ����ʸ��
     * @param dir �ָ��
     */
    static Range initRightRange(Point p, int dir){
        Range range = new Range();

        if (dir == KDTreeTool.DIRECTION_X) {
            range.left = p.x;
        } else {
            range.top = p.y;
        }

        return range;
    }

    /**
     * �ռ�ʸ�����в�����
     *
     * @param range1 �ռ�ʸ������ʾ������Ŀռ䷶Χ
     */
    Range crossOperation(Range range1){
        Range range = new Range();

        // ȡ�����Ҳ����߽�
        if (range1.left > this.left) {
            range.left = range1.left;
        } else {
            range.left = this.left;
        }

        // ȡ���������ұ߽�
        if (range1.right < this.right) {
            range.right = range1.right;
        } else {
            range.right = this.right;
        }

        // ȡ�����²���ϱ߽�
        if (range1.top < this.top) {
            range.top = range1.top;
        } else {
            range.top = this.top;
        }

        // ȡ�����ϲ���±߽�
        if (range1.bottom > this.bottom) {
            range.bottom = range1.bottom;
        } else {
            range.bottom = this.bottom;
        }

        return range;
    }
}
