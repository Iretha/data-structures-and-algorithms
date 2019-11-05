package com.smdev.coding_interview;

public class CI01_CreditCardType {

    public enum CardType {
        VISA_1(null, "4", "VISA"),
        AMEX_1(15, "34", "AMEX"),
        AMEX_2(15, "37", "AMEX"),
        DISCOVER_1(16, "60", "DISCOVER"),
        DISCOVER_2(16, "65", "DISCOVER"),
        DINERS_CLUB_1(14, "30", "DINERS CLUB"),
        DINERS_CLUB_2(14, "36", "DINERS CLUB"),
        DINERS_CLUB_3(14, "38", "DINERS CLUB"),
        MC_1(16, "5", "MC"),
        MC_2(16, "2", "MC"),
        JCB_1(16, "35", "JCB"),
        JCB_2(17, "35", "JCB"),
        JCB_3(18, "35", "JCB"),
        JCB_4(17, "35", "JCB"),
        ;
        private Integer numberLength;
        private String prefix;
        private String type;

        CardType(Integer numberLength, String prefix, String type) {
            this.numberLength = numberLength;
            this.prefix = prefix;
            this.type = type;
        }

        public static String getType(String cardNumber) {
            CardType[] types = CardType.values();
            for (CardType cardType : types) {
                if (cardType.numberLength != null && cardType.numberLength != cardNumber.length()) {
                    continue;
                }
                if (cardNumber.startsWith(cardType.prefix)) {
                    return cardType.type;
                }
            }
            return "UNKNOWN";
        }
    }

    public static void main(String[] args) {
        System.out.println(CardType.getType("4111111111111111"));
        System.out.println(CardType.getType("311111"));
    }
}
