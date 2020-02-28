package sef.module7.activity;

import java.util.Objects;

/**
 * An implementation of the Denomination interface.  The equality test for between instances
 * of this class considers the name and the symbol
 * 
 * @author John Doe
 *
 */
public class DenominationImpl implements Denomination {

	String name;
	String description;
	String symbol;
	/**
	 * Creates a new instance with the specified parameters
	 * 
	 * @param name the name of the denomination
	 * @param description a description 
	 * @param symbol
	 */
	public DenominationImpl(String name, String description, String symbol) {

		this.name = name;
		this.description = description;
		this.symbol = symbol;
	}

	/* (non-Javadoc)
	 * @see sef.module6.activity.Denomination#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}
	
	/* (non-Javadoc)
	 * @see sef.module6.activity.Denomination#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see sef.module6.activity.Denomination#getSymbol()
	 */
	@Override
	public String getSymbol() {
		return symbol;
	}

	@Override
	public String toString() {
		return "DenominationImpl{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				", symbol='" + symbol + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DenominationImpl that = (DenominationImpl) o;
		return Objects.equals(getName(), that.getName()) &&

				Objects.equals(getSymbol(), that.getSymbol());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getDescription(), getSymbol());
	}
}
