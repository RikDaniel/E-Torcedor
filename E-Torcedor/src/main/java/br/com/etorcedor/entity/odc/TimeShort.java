package br.com.etorcedor.entity.odc;

import java.util.ArrayList;
import java.util.List;

import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;

public class TimeShort extends TimePai {

	public TimeShort() {
		super();
	}

	public TimeShort(Long id, String nome, List<TorcidaShort> torcidas) {
		super(id, nome, torcidas);
	}

	public TimeShort(String nome, List<TorcidaShort> torcidas) {
		super(nome, torcidas);
	}

	public static TimeShort toTimeShort(Time time) {
		TimeShort timeshort = new TimeShort();
		if (time != null) {

			List<TorcidaShort> list = new ArrayList<TorcidaShort>();
			timeshort.setId(time.getId());
			timeshort.setNome(time.getNome());
			for (Torcida torcida : time.getTorcidas()) {
				list.add(TorcidaShort.toTorcidaShort(torcida));
			}
			timeshort.setTorcidas(list);
			return timeshort;
		} else {
			return null;
		}
	}

	public static Time toTime(TimeShort timeshort) {
		Time time = new Time();
		List<Torcida> list = new ArrayList<Torcida>();

		time.setNome(timeshort.getNome());
		if (timeshort != null && timeshort.getTorcidas() != null) {
			time.setId(timeshort.getId());
			if(timeshort.getTorcidas() != null)
			for (TorcidaShort torcidas : timeshort.getTorcidas()) {
				list.add(TorcidaShort.toTorcida(torcidas));
			}
			time.setTorcidas(list);
		}
		
		return time;
	}
}
