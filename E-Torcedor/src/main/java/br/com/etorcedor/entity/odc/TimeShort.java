package br.com.etorcedor.entity.odc;

import java.util.ArrayList;
import java.util.List;

import br.com.etorcedor.entity.Time;

public class TimeShort extends TimePai {

	public TimeShort() {
		super();
	}

	public TimeShort(Long id, String nome) {
		super(id, nome);
	}

	public TimeShort(String nome, List<TorcidaShort> torcidas) {
		super(nome);
	}

	public static TimeShort toTimeShort(Time time) {
		TimeShort timeshort = new TimeShort();
		if (time != null) {
			timeshort.setId(time.getId());
			timeshort.setNome(time.getNome());
			return timeshort;
		} else {
			return null;
		}
	}
	
	public static List<TimeShort> toTimeShort(List<Time> time) {
		List<TimeShort> timeshort = new ArrayList<TimeShort>();
		if (time != null) {
			for(Time times : time) {
				timeshort.add(TimeShort.toTimeShort(times));
			}
			return timeshort;
		} else {
			return null;
		}
	}

	public static Time toTime(TimeShort timeshort) {
		Time time = new Time();
		
		if (timeshort != null) {
			time.setNome(timeshort.getNome());
			time.setId(timeshort.getId());
		}
		return time;
	}
	
	public static List<Time> toTime(List<TimeShort>timeshort) {
		List<Time> time = new ArrayList<Time>();
		if (timeshort != null) {
			for(TimeShort timehort : timeshort) {
				time.add(TimeShort.toTime(timehort));
			}
		}
		return time;
	}

}
