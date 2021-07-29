package kr.or.ddit;

public class OrderDetailsVO {
    private String useStatusNo;
    private String id;
    private String customerName;
    private String add1;
    private String add2;
    private String waterLndrCnt;
    private String dryLndrCnt;
    private String blanketLndrCnt;
    private String registDe;
    private String requstDe;

    public OrderDetailsVO(String useStatusNo, String id, String customerName, String add1, String add2, String waterLndrCnt, String dryLndrCnt, String blanketLndrCnt, String registDe, String requstDe) {
        this.useStatusNo = useStatusNo;
        this.id = id;
        this.customerName = customerName;
        this.add1 = add1;
        this.add2 = add2;
        this.waterLndrCnt = waterLndrCnt;
        this.dryLndrCnt = dryLndrCnt;
        this.blanketLndrCnt = blanketLndrCnt;
        this.registDe = registDe;
        this.requstDe = requstDe;
    }

    public String getUseStatusNo() {
        return useStatusNo;
    }

    public void setUseStatusNo(String useStatusNo) {
        this.useStatusNo = useStatusNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAdd1() {
        return add1;
    }

    public void setAdd1(String add1) {
        this.add1 = add1;
    }

    public String getAdd2() {
        return add2;
    }

    public void setAdd2(String add2) {
        this.add2 = add2;
    }

    public String getWaterLndrCnt() {
        return waterLndrCnt;
    }

    public void setWaterLndrCnt(String waterLndrCnt) {
        this.waterLndrCnt = waterLndrCnt;
    }

    public String getDryLndrCnt() {
        return dryLndrCnt;
    }

    public void setDryLndrCnt(String dryLndrCnt) {
        this.dryLndrCnt = dryLndrCnt;
    }

    public String getBlanketLndrCnt() {
        return blanketLndrCnt;
    }

    public void setBlanketLndrCnt(String blanketLndrCnt) {
        this.blanketLndrCnt = blanketLndrCnt;
    }

    public String getRegistDe() {
        return registDe;
    }

    public void setRegistDe(String registDe) {
        this.registDe = registDe;
    }

    public String getRequstDe() {
        return requstDe;
    }

    public void setRequstDe(String requstDe) {
        this.requstDe = requstDe;
    }

    @Override
    public String toString() {
        return "OrderDetailsVO{" +
                "useStatusNo='" + useStatusNo + '\'' +
                ", id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", add1='" + add1 + '\'' +
                ", add2='" + add2 + '\'' +
                ", waterLndrCnt='" + waterLndrCnt + '\'' +
                ", dryLndrCnt='" + dryLndrCnt + '\'' +
                ", blanketLndrCnt='" + blanketLndrCnt + '\'' +
                ", registDe='" + registDe + '\'' +
                ", requstDe='" + requstDe + '\'' +
                '}';
    }
}
