package com.nt.external;

public class ICCScoreCompImpl implements IICCScoreComp {

	@Override
	public String getScore(int mid) {
		System.out.println("ICCScoreCompImpl.getScore()");
		if(mid==101)
			return "IND Vs PAK  :: 304/4(Ind)";
		else if(mid==102)
			return "AUS vs ENG  :: 200/4(ENG)";
		else if(mid==103)
			return "WI vs NZ  :: 294/4(WI)";
		else
			throw new IllegalArgumentException();
	}

}
