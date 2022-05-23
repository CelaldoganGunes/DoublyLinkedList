import java.util.ArrayList;

public class Student {

    private int ogrenciNumarasi;
    private String adSoyad;
    private ArrayList<String> telefonListesi;

    //region Constructor

    public Student()
    {
        this.setOgrenciNumarasi(0);
        this.setAdSoyad(null);
        this.setTelefonListesi(new ArrayList<String>());
    }

    public Student(int nOgrenciNumarasi, String nAdSoyad, ArrayList<String> nTelefonListesi)
    {
        this.setOgrenciNumarasi(nOgrenciNumarasi);
        this.setAdSoyad(nAdSoyad);
        this.setTelefonListesi((ArrayList<String>)  nTelefonListesi.clone());
    }

    public Student(Student oStudent)
    {
        this.setOgrenciNumarasi(oStudent.getOgrenciNumarasi());
        this.setAdSoyad(oStudent.getAdSoyad());
        this.setTelefonListesi((ArrayList<String>)  oStudent.getTelefonListesi().clone());
    }

    //endregion

    //region Get Set Metodları

    public int getOgrenciNumarasi() {
        return ogrenciNumarasi;
    }

    public void setOgrenciNumarasi(int ogrenciNumarasi) {
        this.ogrenciNumarasi = ogrenciNumarasi;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public ArrayList<String> getTelefonListesi() {
        return (ArrayList<String>) telefonListesi.clone();
    }

    public void setTelefonListesi(ArrayList<String> telefonListesi) {
        this.telefonListesi = (ArrayList<String>)  telefonListesi.clone();
    }

    //endregion


}
