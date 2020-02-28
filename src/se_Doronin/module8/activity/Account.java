package se_Doronin.module8.activity;


/**
 * Thsi class represents a simple representation of an account encapsulating
 * a name
 *
 * @author John Doe
 */
public class Account {

    String accountName;

    /**
     * Creates an Account object with the specified name.  If the accout name
     * given violates the minimum requirements, then an AccountException is thrown
     *
     * @param accountName
     * @throws AccountException
     */
    public Account(String accountName) throws AccountException {

        if (accountName.length() < 4)
            throw new AccountException(AccountException.NAME_TOO_SHORT, accountName);
        char[] chars = accountName.toCharArray();

        boolean checkForDigit = false;
        boolean checkForCharacter = false;

        for (char c : chars) {
            if (Character.isDigit(c)) {
                checkForDigit = true;
            }
            if (Character.isLetter(c)) {
                checkForCharacter = true;
            }
        }
        if (!checkForDigit || !checkForCharacter)
            throw new AccountException(AccountException.NAME_TOO_SIMPLE, accountName);

        this.accountName = accountName;
    }


    /**
     * Returns the account name
     *
     * @return the account name
     */
    public String getName() {
        return accountName;
    }
}
