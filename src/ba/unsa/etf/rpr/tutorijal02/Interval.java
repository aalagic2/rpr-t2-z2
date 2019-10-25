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
        if (t>t1 && t<t2) return true;
        if (t==t1 && pripada_t1==true) return true;
        if (t==t2 && pripada_t2==true) return true;
        return false;
    }
    double getT1 () {
        return t1;
    }
    double getT2 () {
        return t2;
    }
    boolean getPripadaT1 () {
        return pripada_t1;
    }
    boolean getPripadaT2 () {
        return pripada_t2;
    }

    @Override
    public String toString () {
        String s="";
        if (this.isNull()==true) return "()";
        if (pripada_t1==true) s+="[";
        else s+="(";
        s+=t1+","+t2;
        if (pripada_t2==true) s+="]";
        else s+=")";
        return s;

    }
    public Interval intersect (Interval i) {
        double a=t1, b=t2, c=i.getT1(), d=i.getT2();
        Interval novi=new Interval();
        if (a<c &&  c<d && d<b) novi=new Interval (c,d,i.getPripadaT1(), i.getPripadaT2());
        else if (c<a && a<b && b<d) novi=new Interval (a,b,this.getPripadaT1(), this.getPripadaT2());
        else if (a<c &&  c<b && b<d) novi=new Interval (c,b, i.getPripadaT1(), this.getPripadaT2());
        else if (c<a && a<d && d<b) novi=new Interval (a,d,this.getPripadaT1(),i.getPripadaT2() );
        else if ((a<b && b<c && c<d) || (c<d && d<a && a<b)) novi=new Interval ();
        return novi;
    }
    public static Interval intersect (Interval i1, Interval i2) {
        Interval i=i1.intersect(i2);
        return i;
    }
    @Override
    public boolean equals (Object o) {
        Interval i=(Interval) o;
        if (i.getT1()!=t1) return false;
        if (i.getT2()!=t2) return false;
        if (i.getPripadaT1()!=pripada_t1) return false;
        if (i.getPripadaT2()!=pripada_t2) return false;
        return true;
    }

}
