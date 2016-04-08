package RoughSets.DataMining_RoughSets;

import java.util.ArrayList;

/**
 * ֪ʶϵͳ
 *
 * @author Qstar
 */
class KnowledgeSystem {
    // ֪ʶϵͳ�ڵļ���
    private ArrayList<RecordCollection> ksCollections;

    KnowledgeSystem(ArrayList<RecordCollection> ksCollections){
        this.ksCollections = ksCollections;
    }

    /**
     * ��ȡ���ϵ��Ͻ��Ƽ���
     *
     * @param rc ԭʼ����
     */
    RecordCollection getUpSimilarRC(RecordCollection rc){
        RecordCollection resultRc = null;
        ArrayList<String> nameArray;
        ArrayList<String> targetArray;
        ArrayList<RecordCollection> copyRcs = new ArrayList<>();
        ArrayList<RecordCollection> deleteRcs = new ArrayList<>();
        targetArray = rc.getRecordNames();

        // ��һ�����Ͽ���
        copyRcs.addAll(ksCollections);

        for (RecordCollection recordCollection : copyRcs) {
            nameArray = recordCollection.getRecordNames();

            if (strIsContained(targetArray, nameArray)) {
                removeOverLaped(targetArray, nameArray);
                deleteRcs.add(recordCollection);

                if (resultRc == null) {
                    resultRc = recordCollection;
                } else {
                    // ���в�����
                    resultRc = resultRc.unionCal(recordCollection);
                }

                if (targetArray.size() == 0) {
                    break;
                }
            }
        }
        //ȥ���Ѿ���ӹ��ļ���
        copyRcs.removeAll(deleteRcs);

        if (targetArray.size() > 0) {
            // ˵���Ѿ���ȫ��δ��ȫ�Ͻ��Ƶļ���
            for (RecordCollection recordCollection : copyRcs) {
                nameArray = recordCollection.getRecordNames();

                if (strHasOverlap(targetArray, nameArray)) {
                    removeOverLaped(targetArray, nameArray);

                    if (resultRc == null) {
                        resultRc = recordCollection;
                    } else {
                        // ���в�����
                        resultRc = resultRc.unionCal(recordCollection);
                    }

                    if (targetArray.size() == 0) {
                        break;
                    }
                }
            }
        }

        return resultRc;
    }

    /**
     * ��ȡ���ϵ��½��Ƽ���
     *
     * @param rc ԭʼ����
     */
    RecordCollection getDownSimilarRC(RecordCollection rc){
        RecordCollection resultRc = null;
        ArrayList<String> nameArray;
        ArrayList<String> targetArray;
        targetArray = rc.getRecordNames();

        for (RecordCollection recordCollection : ksCollections) {
            nameArray = recordCollection.getRecordNames();

            if (strIsContained(targetArray, nameArray)) {
                removeOverLaped(targetArray, nameArray);

                if (resultRc == null) {
                    resultRc = recordCollection;
                } else {
                    // ���в�����
                    resultRc = resultRc.unionCal(recordCollection);
                }

                if (targetArray.size() == 0) {
                    break;
                }
            }
        }

        return resultRc;
    }

    /**
     * �ж�2���ַ�����֮���Ƿ��н���
     *
     * @param str1 �ַ��б�1
     * @param str2 �ַ��б�2
     */
    private boolean strHasOverlap(ArrayList<String> str1, ArrayList<String> str2){
        boolean hasOverlap = false;

        for (String s1 : str1) {
            for (String s2 : str2) {
                if (s1.equals(s2)) {
                    hasOverlap = true;
                    break;
                }
            }

            if (hasOverlap) {
                break;
            }
        }

        return hasOverlap;
    }

    /**
     * �ж��ַ���str2�Ƿ���ȫ������str1��
     *
     * @param str1 �ַ���1
     * @param str2 �ַ���2
     */
    private boolean strIsContained(ArrayList<String> str1, ArrayList<String> str2){
        boolean isContained = false;
        int count = 0;

        for (String s : str2) {
            if (str1.contains(s)) {
                count++;
            }
        }

        if (count == str2.size()) {
            isContained = true;
        }

        return isContained;
    }

    /**
     * �ַ��б��Ƴ�����Ԫ��
     *
     * @param str1 �ַ��б�1
     * @param str2 �ַ��б�2
     */
    private void removeOverLaped(ArrayList<String> str1, ArrayList<String> str2){
        ArrayList<String> deleteStrs = new ArrayList<>();

        for (String s1 : str1) {
            for (String s2 : str2) {
                if (s1.equals(s2)) {
                    deleteStrs.add(s1);
                    break;
                }
            }
        }

        // ���й���Ԫ�ص��Ƴ�
        str1.removeAll(deleteStrs);
    }
}
