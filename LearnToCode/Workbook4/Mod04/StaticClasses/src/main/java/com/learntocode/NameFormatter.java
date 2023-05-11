package com.learntocode;

public class NameFormatter {

    // Private constructor to prevent instantiation of this class
    private NameFormatter() {
    }

    public static String format(String firstName, String lastName) {
        return format("", firstName, "", lastName, "");
    }

    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
        StringBuilder sb = new StringBuilder();

        sb.append(lastName).append(", ");

        if (!prefix.isEmpty()) {
            sb.append(prefix).append(" ");
        }

        sb.append(firstName);

        if (!middleName.isEmpty()) {
            sb.append(" ").append(middleName);
        }
        if (!suffix.isEmpty()) {
            sb.append(", ").append(suffix);
        }
        return sb.toString();
    }

    public static String format(String fullName) {
        String prefix = "";
        String firstName = "";
        String middleName = "";
        String lastName = "";
        String suffix = "";

        if (fullName.indexOf(',') != -1) {
            String[] nameParts = fullName.split(", ");
            suffix = nameParts[1];

            String firstPart = nameParts[0];
            String[] nameParts2 = firstPart.split(" ");

            if (nameParts2.length == 4) {
                prefix = nameParts2[0];
                firstName = nameParts2[1];
                middleName = nameParts2[2];
                lastName = nameParts2[3];
            } else if (nameParts2.length == 3) {
                firstName = nameParts2[0];
                middleName = nameParts2[1];
                lastName = nameParts2[2];
            }
        } else {
            String[] nameParts = fullName.split(" ");
            firstName = nameParts[0];
            lastName = nameParts[1];
        }

        return format(prefix, firstName, middleName, lastName, suffix);
    }
}


