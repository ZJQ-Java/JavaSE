package ExcelTest;

import java.util.List;
import java.util.Map;

public class seatBody {
    private String                     workUID;
    private String                     workerName;
    private String                     workerNickName;
    private Map<String, List<Integer>> mapDate;

    public String getWorkUID() {
        return workUID;
    }

    public void setWorkUID(String workUID) {
        this.workUID = workUID;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerNickName() {
        return workerNickName;
    }

    public void setWorkerNickName(String workerNickName) {
        this.workerNickName = workerNickName;
    }

    public Map<String, List<Integer>> getMapDate() {
        return mapDate;
    }

    public void setMapDate(Map<String, List<Integer>> mapDate) {
        this.mapDate = mapDate;
    }

    public seatBody() {
    }
}
