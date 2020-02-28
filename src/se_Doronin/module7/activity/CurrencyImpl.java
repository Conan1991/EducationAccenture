package sef.module7.activity;

import java.util.Calendar;
import java.util.Objects;

/**
 * Represents an implementation of the Currency interface.  The equality test for
 * this currency implementation requires that the value and the name of the denomination
 * must be true in order to be considered equal.
 * 
 * @author John Doe
 *
 */
public class CurrencyImpl implements Currency {
	
	private float value;
	private Denomination denomination;
	private Calendar createDate;


	/**
	 * Creates an instance of the of the Currency class with the specified
	 * value and denomination
	 * 
	 * @param value the value of the currency 
	 * @param denomination the denomination of the currency
	 */
	public CurrencyImpl(float value, Denomination denomination) {
		this.value = value;
		this.denomination = new DenominationImpl(denomination.getName(), denomination.getDescription(), denomination.getSymbol());
		this.createDate = Calendar.getInstance();
	}


	@Override
	public float getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see sef.module6.activity.Currency#getDenomination()
	 */
	@Override
	public Denomination getDenomination() {
		return denomination;
	}

	/* (non-Javadoc)
	 * @see sef.module6.activity.Currency#getCreateDate()
	 */
	@Override
	public Calendar getCreateDate() {
		return (Calendar) createDate.clone();
	}

	@Override
	public String toString() {
		return "CurrencyImpl{" +
				"value=" + value +
				", denomination=" + denomination +
				", createDate=" + createDate +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CurrencyImpl currency = (CurrencyImpl) o;
		return Float.compare(currency.getValue(), getValue()) == 0 &&
				Objects.equals(getDenomination(), currency.getDenomination()) &&
				Objects.equals(getCreateDate(), currency.getCreateDate());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getValue(), getDenomination(), getCreateDate());
	}
}
