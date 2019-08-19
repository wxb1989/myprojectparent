package com.edison.csv;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-19 14:30
 **/
public class LianlianTrade {

    /**
     * 如为正交易则是商户系统发起正交易时的唯一订单号，如为退款交易则是商户发起退款时商户系统的唯一订单号；
     */
    @CsvResources(title="商户订单号",order=1,type="String")
    private String orderNum;

    /**
     * 商户编号是商户在连连支付平台上开设的商户唯一编号，为 18 位数字，
     */
    @CsvResources(title="商户号",order=2,type="String")
    private String merchantID;
    /**
     * 订单创建时间
     */
    @CsvResources(title="商户订单时间",order=3)
    private String llCreateTime;
    /**
     * 业务类型为虚拟商品销售（101001）或实物商品销售（109001），交易请求时的busi_partner字段；
     */
    @CsvResources(title="商户业务编号",order=4)
    private String bussinessType;
    /**
     * 连连支付系统唯一订单号，如为正交易，则是交易请求时连连支付返回的oid_paybill字段；如为退款交易，则是退款所关联的正交易的商户订单号；
     */
    @CsvResources(title="银通订单号",order=5,type="String")
    private String llPayNum;
    /**
     * 账务日期是该笔订单支付成功后返回的清算日期；
     */
    @CsvResources(title="银通账务日期",order=6)
    private String llPayDate;
    /**
     * 订单金额，如为退款，则为该笔退款单的退款金额（退款则金额为负）；
     */
    @CsvResources(title="订单金额",order=7)
    private double amount;
    /**
     * 原单商户收付款标志，0为商户收款，1为商户付款，因此支付对账单统一为0
     */
    @CsvResources(title="商户收付款标志(0收款 1付款)",order=8)
    private int type;
    /**
     * 交易状态，0为正交易成功，5为退款，
     */
    @CsvResources(title="交易状态(0-成功 5-退款)",order=9)
    private int status;


    /**
     * 更新时间是该笔订单最终状态更新的时间，如为正交易，则是交易成功时间，如退款，则是退款成功时间。
     */
    @CsvResources(title="更新时间",order=10)
    private String llUpdateTime;
    /**
     * 手续费是该笔订单连连支付应收手续费（退款则金额为负）；
     */
    @CsvResources(title="手续费",order=11)
    private double serviceFee;
    /**
     * 商户使用的支付产品，WEB支付网关:WEB、手机应用支付网关:SDK、WAP支付网关:WAP、API接口:API、
     */
    @CsvResources(title="支付产品",order=12)
    private String payProduct;
    /**
     * 商户使用的支付方式，
     * 储蓄卡网银支付：Debit Card EBank Payment、
     * 信用卡网银支付：Credit Card EBank Payment、
     * 储蓄卡快捷支付：Debit Card Express Payment、
     * 信用卡快捷支付：Credit Card Express Payment、
     * 企业网银支付：Corporate Ebank Payment
     */
    @CsvResources(title="支付方式",order=13)
    private String payMethod;
    /**
     * 订单信息为交易请求时的info_order字段；
     */
    @CsvResources(title="订单信息",order=14)
    private String orderInfo;
    /**
     * 收款人银行：商户代付的对象的银行卡所属银行，如农业银行、工商银行等；
     */
    @CsvResources(title="收款方银行",order=15)
    private String targetBank;
    /**
     * 收款人银行帐号：商户代付的对象的银行卡卡号，显示卡号最后4位；
     */
    @CsvResources(title="收款方账号",order=16)
    private String targetCardNum;
    /**
     * 收款人姓名，商户代付对象的姓名；
     */
    @CsvResources(title="收款方名称",order=17)
    private String targetName;


    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }

    public String getLlCreateTime() {
        return llCreateTime;
    }

    public void setLlCreateTime(String llCreateTime) {
        this.llCreateTime = llCreateTime;
    }

    public String getBussinessType() {
        return bussinessType;
    }

    public void setBussinessType(String bussinessType) {
        this.bussinessType = bussinessType;
    }

    public String getLlPayNum() {
        return llPayNum;
    }

    public void setLlPayNum(String llPayNum) {
        this.llPayNum = llPayNum;
    }

    public String getLlPayDate() {
        return llPayDate;
    }

    public void setLlPayDate(String llPayDate) {
        this.llPayDate = llPayDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLlUpdateTime() {
        return llUpdateTime;
    }

    public void setLlUpdateTime(String llUpdateTime) {
        this.llUpdateTime = llUpdateTime;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getPayProduct() {
        return payProduct;
    }

    public void setPayProduct(String payProduct) {
        this.payProduct = payProduct;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String getTargetBank() {
        return targetBank;
    }

    public void setTargetBank(String targetBank) {
        this.targetBank = targetBank;
    }

    public String getTargetCardNum() {
        return targetCardNum;
    }

    public void setTargetCardNum(String targetCardNum) {
        this.targetCardNum = targetCardNum;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }
}
