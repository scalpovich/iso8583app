package com.finastra.fpm.util.iso8583simulator.model;

import com.finastra.fpm.util.iso8583simulator.message.ISO8583MessageType;

public class ISO8583Message {

    private static final String MESSAGE_TYPE = ISO8583MessageType.DREQ.getMessageType();

    private String primaryaccountnumber;
    private String processingcode;
    private String txamount;
    private String settlementamount;
    private String chbillingamount;
    private String transmissiondatetime;
    private String settlementconversionrate;
    private String cardholderconversionrate;
    private String systraceauditnum;
    private String timelocaltx;
    private String datelocaltx;
    private String expirationdate;
    private String datesettlement;
    private String merchanttype;
    private String acqinstcountrycode;
    private String ptofserviceentrymodecode;
    private String ptofserviceconditioncode;
    private String acqinstidcode;
    private String retrievalrefnum;
    private String authidresp;
    private String respcode;
    private String cardaccpterminalid;
    private String cardaccpidcode;
    private String cardaccpnmloc;
    private String addtldataprivate;
    private String txcurcode;
    private String settelmentcurcode;
    private String curcodecardholderbilling;
    private String usrdefinedfld;
    private String servccode;
    private String txrefnum;
    private String networkmgtrespcode;
    private String recvinstidcode;
    private String fromacctid;
    private String toacctid;
    private String contenttransfers;
    private String infochaccthbeneficiary;
    private String msgauthcode;

    public String getPrimaryaccountnumber() {
        return primaryaccountnumber;
    }

    public void setPrimaryaccountnumber(String primaryaccountnumber) {
        this.primaryaccountnumber = primaryaccountnumber;
    }

    public String getProcessingcode() {
        return processingcode;
    }

    public void setProcessingcode(String processingcode) {
        this.processingcode = processingcode;
    }

    public String getTxamount() {
        return txamount;
    }

    public void setTxamount(String txamount) {
        this.txamount = txamount;
    }

    public String getSettlementamount() {
        return settlementamount;
    }

    public void setSettlementamount(String settlementamount) {
        this.settlementamount = settlementamount;
    }

    public String getChbillingamount() {
        return chbillingamount;
    }

    public void setChbillingamount(String chbillingamount) {
        this.chbillingamount = chbillingamount;
    }

    public String getTransmissiondatetime() {
        return transmissiondatetime;
    }

    public void setTransmissiondatetime(String transmissiondatetime) {
        this.transmissiondatetime = transmissiondatetime;
    }

    public String getSettlementconversionrate() {
        return settlementconversionrate;
    }

    public void setSettlementconversionrate(String settlementconversionrate) {
        this.settlementconversionrate = settlementconversionrate;
    }

    public String getCardholderconversionrate() {
        return cardholderconversionrate;
    }

    public void setCardholderconversionrate(String cardholderconversionrate) {
        this.cardholderconversionrate = cardholderconversionrate;
    }

    public String getSystraceauditnum() {
        return systraceauditnum;
    }

    public void setSystraceauditnum(String systraceauditnum) {
        this.systraceauditnum = systraceauditnum;
    }

    public String getTimelocaltx() {
        return timelocaltx;
    }

    public void setTimelocaltx(String timelocaltx) {
        this.timelocaltx = timelocaltx;
    }

    public String getDatelocaltx() {
        return datelocaltx;
    }

    public void setDatelocaltx(String datelocaltx) {
        this.datelocaltx = datelocaltx;
    }

    public String getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate;
    }

    public String getDatesettlement() {
        return datesettlement;
    }

    public void setDatesettlement(String datesettlement) {
        this.datesettlement = datesettlement;
    }

    public String getMerchanttype() {
        return merchanttype;
    }

    public void setMerchanttype(String merchanttype) {
        this.merchanttype = merchanttype;
    }

    public String getAcqinstcountrycode() {
        return acqinstcountrycode;
    }

    public void setAcqinstcountrycode(String acqinstcountrycode) {
        this.acqinstcountrycode = acqinstcountrycode;
    }

    public String getPtofserviceentrymodecode() {
        return ptofserviceentrymodecode;
    }

    public void setPtofserviceentrymodecode(String ptofserviceentrymodecode) {
        this.ptofserviceentrymodecode = ptofserviceentrymodecode;
    }

    public String getPtofserviceconditioncode() {
        return ptofserviceconditioncode;
    }

    public void setPtofserviceconditioncode(String ptofserviceconditioncode) {
        this.ptofserviceconditioncode = ptofserviceconditioncode;
    }

    public String getAcqinstidcode() {
        return acqinstidcode;
    }

    public void setAcqinstidcode(String acqinstidcode) {
        this.acqinstidcode = acqinstidcode;
    }

    public String getRetrievalrefnum() {
        return retrievalrefnum;
    }

    public void setRetrievalrefnum(String retrievalrefnum) {
        this.retrievalrefnum = retrievalrefnum;
    }

    public String getAuthidresp() {
        return authidresp;
    }

    public void setAuthidresp(String authidresp) {
        this.authidresp = authidresp;
    }

    public String getRespcode() {
        return respcode;
    }

    public void setRespcode(String respcode) {
        this.respcode = respcode;
    }

    public String getCardaccpterminalid() {
        return cardaccpterminalid;
    }

    public void setCardaccpterminalid(String cardaccpterminalid) {
        this.cardaccpterminalid = cardaccpterminalid;
    }

    public String getCardaccpidcode() {
        return cardaccpidcode;
    }

    public void setCardaccpidcode(String cardaccpidcode) {
        this.cardaccpidcode = cardaccpidcode;
    }

    public String getCardaccpnmloc() {
        return cardaccpnmloc;
    }

    public void setCardaccpnmloc(String cardaccpnmloc) {
        this.cardaccpnmloc = cardaccpnmloc;
    }

    public String getAddtldataprivate() {
        return addtldataprivate;
    }

    public void setAddtldataprivate(String addtldataprivate) {
        this.addtldataprivate = addtldataprivate;
    }

    public String getTxcurcode() {
        return txcurcode;
    }

    public void setTxcurcode(String txcurcode) {
        this.txcurcode = txcurcode;
    }

    public String getSettelmentcurcode() {
        return settelmentcurcode;
    }

    public void setSettelmentcurcode(String settelmentcurcode) {
        this.settelmentcurcode = settelmentcurcode;
    }

    public String getCurcodecardholderbilling() {
        return curcodecardholderbilling;
    }

    public void setCurcodecardholderbilling(String curcodecardholderbilling) {
        this.curcodecardholderbilling = curcodecardholderbilling;
    }

    public String getUsrdefinedfld() {
        return usrdefinedfld;
    }

    public void setUsrdefinedfld(String usrdefinedfld) {
        this.usrdefinedfld = usrdefinedfld;
    }

    public String getServccode() {
        return servccode;
    }

    public void setServccode(String servccode) {
        this.servccode = servccode;
    }

    public String getTxrefnum() {
        return txrefnum;
    }

    public void setTxrefnum(String txrefnum) {
        this.txrefnum = txrefnum;
    }

    public String getNetworkmgtrespcode() {
        return networkmgtrespcode;
    }

    public void setNetworkmgtrespcode(String networkmgtrespcode) {
        this.networkmgtrespcode = networkmgtrespcode;
    }

    public String getRecvinstidcode() {
        return recvinstidcode;
    }

    public void setRecvinstidcode(String recvinstidcode) {
        this.recvinstidcode = recvinstidcode;
    }

    public String getFromacctid() {
        return fromacctid;
    }

    public void setFromacctid(String fromacctid) {
        this.fromacctid = fromacctid;
    }

    public String getToacctid() {
        return toacctid;
    }

    public void setToacctid(String toacctid) {
        this.toacctid = toacctid;
    }

    public String getContenttransfers() {
        return contenttransfers;
    }

    public void setContenttransfers(String contenttransfers) {
        this.contenttransfers = contenttransfers;
    }

    public String getInfochaccthbeneficiary() {
        return infochaccthbeneficiary;
    }

    public void setInfochaccthbeneficiary(String infochaccthbeneficiary) {
        this.infochaccthbeneficiary = infochaccthbeneficiary;
    }

    public String getMsgauthcode() {
        return msgauthcode;
    }

    public void setMsgauthcode(String msgauthcode) {
        this.msgauthcode = msgauthcode;
    }

    public static String getMessageType() {
        return MESSAGE_TYPE;
    }

    @Override
    public String toString() {
        return "ISO8583Message{" +
                "primaryaccountnumber='" + primaryaccountnumber + '\'' +
                ", processingcode='" + processingcode + '\'' +
                ", txamount='" + txamount + '\'' +
                ", settlementamount='" + settlementamount + '\'' +
                ", chbillingamount='" + chbillingamount + '\'' +
                ", transmissiondatetime='" + transmissiondatetime + '\'' +
                ", settlementconversionrate='" + settlementconversionrate + '\'' +
                ", cardholderconversionrate='" + cardholderconversionrate + '\'' +
                ", systraceauditnum='" + systraceauditnum + '\'' +
                ", timelocaltx='" + timelocaltx + '\'' +
                ", datelocaltx='" + datelocaltx + '\'' +
                ", expirationdate='" + expirationdate + '\'' +
                ", datesettlement='" + datesettlement + '\'' +
                ", merchanttype='" + merchanttype + '\'' +
                ", acqinstcountrycode='" + acqinstcountrycode + '\'' +
                ", ptofserviceentrymodecode='" + ptofserviceentrymodecode + '\'' +
                ", ptofserviceconditioncode='" + ptofserviceconditioncode + '\'' +
                ", acqinstidcode='" + acqinstidcode + '\'' +
                ", retrievalrefnum='" + retrievalrefnum + '\'' +
                ", authidresp='" + authidresp + '\'' +
                ", respcode='" + respcode + '\'' +
                ", cardaccpterminalid='" + cardaccpterminalid + '\'' +
                ", cardaccpidcode='" + cardaccpidcode + '\'' +
                ", cardaccpnmloc='" + cardaccpnmloc + '\'' +
                ", addtldataprivate='" + addtldataprivate + '\'' +
                ", txcurcode='" + txcurcode + '\'' +
                ", settelmentcurcode='" + settelmentcurcode + '\'' +
                ", curcodecardholderbilling='" + curcodecardholderbilling + '\'' +
                ", usrdefinedfld='" + usrdefinedfld + '\'' +
                ", servccode='" + servccode + '\'' +
                ", txrefnum='" + txrefnum + '\'' +
                ", networkmgtrespcode='" + networkmgtrespcode + '\'' +
                ", recvinstidcode='" + recvinstidcode + '\'' +
                ", fromacctid='" + fromacctid + '\'' +
                ", toacctid='" + toacctid + '\'' +
                ", contenttransfers='" + contenttransfers + '\'' +
                ", infochaccthbeneficiary='" + infochaccthbeneficiary + '\'' +
                ", msgauthcode='" + msgauthcode + '\'' +
                '}';
    }

}
