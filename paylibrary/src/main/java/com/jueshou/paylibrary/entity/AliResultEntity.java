package com.jueshou.paylibrary.entity;

/**
 * Created by Android Studio .
 * 作者：zhong
 * 日期：2018/5/21
 * 邮箱：15206394364@163.com
 * 介绍：
 * 修订：====================
 */
public class AliResultEntity {

    /**
     * resultStatus : 4000
     * result : {"alipay_trade_app_pay_response":{"code":"40002","msg":"Invalid Arguments","sub_code":"isv.invalid-signature","sub_msg":"验签出错，sign值与sign_type参数指定的签名类型不一致：sign_type参数值为RSA2，您实际用的签名类型可能是RSA"}}
     * memo :
     */

    private int resultStatus;
    private ResultBean result;
    private String memo;

    public int getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(int resultStatus) {
        this.resultStatus = resultStatus;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public static class ResultBean {
        /**
         * alipay_trade_app_pay_response : {"code":"40002","msg":"Invalid Arguments","sub_code":"isv.invalid-signature","sub_msg":"验签出错，sign值与sign_type参数指定的签名类型不一致：sign_type参数值为RSA2，您实际用的签名类型可能是RSA"}
         */

        private AlipayTradeAppPayResponseBean alipay_trade_app_pay_response;

        public AlipayTradeAppPayResponseBean getAlipay_trade_app_pay_response() {
            return alipay_trade_app_pay_response;
        }

        public void setAlipay_trade_app_pay_response(AlipayTradeAppPayResponseBean alipay_trade_app_pay_response) {
            this.alipay_trade_app_pay_response = alipay_trade_app_pay_response;
        }

        public static class AlipayTradeAppPayResponseBean {
            /**
             * code : 40002
             * msg : Invalid Arguments
             * sub_code : isv.invalid-signature
             * sub_msg : 验签出错，sign值与sign_type参数指定的签名类型不一致：sign_type参数值为RSA2，您实际用的签名类型可能是RSA
             */

            private String code;
            private String msg;
            private String sub_code;
            private String sub_msg;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public String getSub_code() {
                return sub_code;
            }

            public void setSub_code(String sub_code) {
                this.sub_code = sub_code;
            }

            public String getSub_msg() {
                return sub_msg;
            }

            public void setSub_msg(String sub_msg) {
                this.sub_msg = sub_msg;
            }
        }
    }
}
