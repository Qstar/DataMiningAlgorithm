package Others.DataMining_KDTree;

/**
 * 空间矢量，表示所代表的空间范围
 *
 * @author Qstar
 */
class Range {
    // 边界左边界
    private double left;
    // 边界右边界
    private double right;
    // 边界上边界
    private double top;
    // 边界下边界
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
     * 根据坐标点分割方向确定左侧空间矢量
     *
     * @param p   数据矢量
     * @param dir 分割方向
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
     * 根据坐标点分割方向确定右侧空间矢量
     *
     * @param p   数据矢量
     * @param dir 分割方向
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
     * 空间矢量进行并操作
     *
     * @param range1 空间矢量，表示所代表的空间范围
     */
    Range crossOperation(Range range1){
        Range range = new Range();

        // 取靠近右侧的左边界
        if (range1.left > this.left) {
            range.left = range1.left;
        } else {
            range.left = this.left;
        }

        // 取靠近左侧的右边界
        if (range1.right < this.right) {
            range.right = range1.right;
        } else {
            range.right = this.right;
        }

        // 取靠近下侧的上边界
        if (range1.top < this.top) {
            range.top = range1.top;
        } else {
            range.top = this.top;
        }

        // 取靠近上侧的下边界
        if (range1.bottom > this.bottom) {
            range.bottom = range1.bottom;
        } else {
            range.bottom = this.bottom;
        }

        return range;
    }
}
