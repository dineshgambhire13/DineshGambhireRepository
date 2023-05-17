import java.util.List;

public class Search {

	public static int linearSearch(List<CricketTeam> teams, String key) {
		CricketTeam keyTeam = new CricketTeam(key);
		for(int i = 0; i < teams.size(); i++) {
			if(teams.get(i).equals(keyTeam)) {
				return i;
			}
		}
		return -1;
	}
	
	public static int recBinarySearch(List<CricketTeam> teams, String key) {
		int left = 0, right = teams.size() - 1;
		return recBinarySearch(teams, key, left, right);
	}
	
	public static int recBinarySearch(List<CricketTeam> teams, String key, int left, int right) {
		if(left > right)
			return -1;
		
		int mid, index;
		
		mid = (left + right) / 2;
		CricketTeam keyTeam = new CricketTeam(key);
		if(keyTeam.equals(teams.get(mid)))
			return mid;
		if(keyTeam.compareTo(teams.get(mid)) < 0)
			index = recBinarySearch(teams, key, left, mid - 1);
		else
			index = recBinarySearch(teams, key, mid + 1, right);
		return index;
	}
}
