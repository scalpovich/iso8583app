package com.finastra.fpm.util.iso8583simulator.message;

public enum Fields {
    SECONDARY_BITMAP("SecondaryBitMap", 1),
    PAN("PAN", 2),
    PROCESSING_CODE("ProcessingCode", 3),
    TXN_AMT("TransactionAmount", 4),
    STL_AMT("SettlementAmount", 5),
    CARDHOLDER_BILL_AMT("CardholderBillAmount", 6),
    TXN_DATETIME("TransDateTime", 7),
    STL_CONV_RATE("StlConvRate", 9),
    CARDHOLDER_CONV_RATE("CardholderConvRate", 10),
    SYS_TRACE_AUD_NUM("SysTraceAudNum", 11),
    LOCAL_TXN_TIME("LocalTxnTime", 12),
    LOCAL_TXN_DATE("LocalTxnDate", 13),
    EXPIRATION_DATE("ExpirationDate", 14),
    STL_DATE("StlDate", 15),
    MERCHANT_TYPE("MerchantType", 18),
    ACQ_INST_CTRY_CODE("AcqInstCtryCode", 19),
    PT_SRV_ENTRY_MODE_CODE("PtOfSrvEntryModeCode", 22),
    PT_SRV_COND_CODE("PtOfSrvCondCode", 25),
    ACQ_INST_ID_CODE("AcqInstIdCode", 32),
    RETRIEVAL_REF_NO("RetrievalRefNum", 37),
    AUTH_ID_RESP("AuthIdResponse", 38),
    RESPONSE_CODE("ResponseCode", 39),
    CARD_ACCP_TERM_ID("CardAcceptorTermId", 41),
    CARD_ACCP_ID_CODE("CardAcceptorIdCode", 42),
    CARD_ACCP_NM_LOC("CardAcceptorNmLoc", 43),
    ADDL_DATA_PVT_LTD("AddlDataPvt", 48),
    TXN_CURR_CODE("TxnCurrCode", 49),
    STL_CURR_CODE("StlCurrCode", 50),
    CARDHOLDER_CURR_CODE("CardHolderCurrCode", 51),
    UDF("UsrDefinedFld", 60),
    SRV_CODE("ServiceCode", 62),
    TXN_REF_NO("TxnReferenceNumber", 63),
    NETWK_MGMT_INFO_CODE("NetworkMgmtInfoCode", 70),
    RECV_INST_ID_CODE("RecvInstIdCode", 100),
    FROM_ACCT_ID("FromAcctId", 102),
    TO_ACCT_ID("ToAcctId", 103),
    CONTENT_TRANSFERS("ContentTransfers", 104),
    CARDHOLDER_INFO("CardHolderInfo", 120),
    MAC("MsgAuthCode", 128);

    private String name;
    private int pos;

    private Fields(String fieldName, int pos){
        this.name = fieldName;
        this.pos = pos;
    }

    public String getName(){
        return this.name;
    }

    public int getPos(){
        return this.pos;
    }
}
