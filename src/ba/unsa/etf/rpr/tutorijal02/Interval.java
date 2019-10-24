package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double t1, t2;
    private boolean pripada_t1, pripada_t2;
    public Interval (double t1, double t2, boolean pripada_t1, boolean pripada_t2){
        if (t1>t2) throw new IllegalArgumentException ("Izuzetak: pocetna tacka veca od krajnje");
        this.t1=t1;
        this.t2=t2;
        this.pripada_t1=pripada_t1;
        this.pripada_t2=pripada_t2;
    }
    public Interval () {
        this.t1=0;
        this.t2=0;
        this.pripada_t1=false;
        this.pripada_t2=false;
    }
    public boolean isNull (){
        if (t1==0 && t2==0 && pripada_t1==false && pripada_t2==false) return true;
        return false;
    }
    public boolean isIn (double t) {
        if (t>=t1 && t<=t2) return true;
        return false;
    }
}
