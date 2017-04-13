import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by gladkiy_v on 13.04.2017.
 */
 class IdReport  {

    int countMonth = 0;
    public void getZodiac(int d)
    {
        if (d < m[countMonth])
        {
            zodiacName = ZodiacNames[countMonth];
        }
        else
        {
            if(countMonth>10)
                zodiacName = ZodiacNames[0];
        }
    }
    private String Id;
    private int idNumber;
    public enum mTable{jen,feb,mar,app,may,jun,jul,aug,sep,oct,nov,dec;};
    String[] ZodiacNames = {"Vodoley", "Fish", "Oven", "Telec", "Bliznecu","Rak","Lev","Deva","Vecu","Scorpion","Strelec","Kozerog"};
    int[] m = {21,20,21,21,22,22,23,22,24,24,23,23};
    private int year=0;
    private String month = "";
    private int day = 0;
    private  char numberOfDays[] = new char[5];
    private char countNumber[] = new char[4];
    private char gender;
    private char control;
    private String zodiacName;

    Map<String, Integer> zodiacList;
    {
        zodiacList = new LinkedHashMap<String, Integer>();
        zodiacList.put("Vodoley", 21 );
        zodiacList.put("Rubu", 20 );
        zodiacList.put("Oven", 21 );
        zodiacList.put("Telec", 21 );
        zodiacList.put("Blizneci", 22 );
        zodiacList.put("Rack", 22 );
        zodiacList.put("Lev", 23 );
        zodiacList.put("Deva", 22 );
        zodiacList.put("Vesu", 24 );
        zodiacList.put("Scorpion", 24 );
        zodiacList.put("Strelec", 23 );
        zodiacList.put("Kozerog", 23 );
    }

    public    Map<mTable,Integer> monthList;
    {
        monthList = new LinkedHashMap<mTable, Integer>();
        monthList.put(mTable.jen, 31);
        monthList.put(mTable.feb, 28);
        monthList.put(mTable.mar, 31);
        monthList.put(mTable.app, 30);
        monthList.put(mTable.may, 31);
        monthList.put(mTable.jun, 30);
        monthList.put(mTable.jul, 31);
        monthList.put(mTable.aug, 31);
        monthList.put(mTable.sep, 30);
        monthList.put(mTable.oct, 31);
        monthList.put(mTable.nov, 30);
        monthList.put(mTable.dec, 31);
    }

    public IdReport(String s){
        this.Id = s;
        Id.getChars(0,5,numberOfDays,0);
        Id.getChars(5,9,countNumber,0);
        gender = Id.charAt(9);
        control = Id.charAt(10);
        CountBirthDate(numberOfDays);
        checkGender();
        getZodiac(day);
    }

    public void getReport(){
        System.out.println("--------------------------");
        System.out.println("Gender: " + gender);
        System.out.println("Count Id: " + String.valueOf(countNumber));
        System.out.println("Birth day");
        System.out.println("\nday: " + day + "\nmonth: " + month + "\nyear: " + (year + 1900));
        System.out.println(zodiacName);
    }
    private void CountBirthDate(char[] inputData){
        int count = 0;
        int leap = 3;

        for(int i = 0; i < 5; i++){
            count += (inputData[i] - '0')*10000/Math.pow(10,i);
        }
        count++;
        while (count > 365 || count > 366) {
            if (leap == 3) {
                count -= 366;
                leap = 0;
                year++;
            } else {
                count -= 365;
                leap++;
                year++;
            }
        }

        for (Map.Entry<mTable,Integer> a: monthList.entrySet()
                ) {
            if(count > a.getValue()){
                count -=a.getValue();
            }
            else
            {
                month=a.getKey().name();
                day=count;

                break;
            }
            countMonth++;
        }
    }

    void checkGender(){

        int x = Integer.valueOf(gender) % 2;

        if(!(x == 0))
        {gender='f';}
        else {gender='m';}
    }

}
