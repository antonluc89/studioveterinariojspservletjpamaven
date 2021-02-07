package it.studioveterinariojspservletmavenjpa.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class Utility {
	public Long parseIdEntryToLongFromString(String idEntryStringParam) {
		if (StringUtils.isBlank(idEntryStringParam))
			return null;

		try {
			return Long.parseLong(idEntryStringParam);
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean validateInput(String nomeInputParam, String razzaInputParam, String etaInputStringParam,
			String dataPrenotazioneStringParam) {
		if (StringUtils.isBlank(nomeInputParam) || StringUtils.isBlank(razzaInputParam)
				|| !NumberUtils.isCreatable(etaInputStringParam) || StringUtils.isBlank(dataPrenotazioneStringParam)) {
			return false;
		}
		return true;
	}

	public Date parseDatePrenotazioneFromString(String dataPrenotazioneStringParam) {
		if (StringUtils.isBlank(dataPrenotazioneStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataPrenotazioneStringParam);
		} catch (ParseException e) {
			return null;
		}
	}
}
