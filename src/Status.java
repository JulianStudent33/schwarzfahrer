package src;

import java.io.Serializable;
import java.time.LocalDate;

public class Status implements Serializable {

   public String status;
   public boolean isOffen;
   public boolean isAusstehend;
   public boolean isBezahlt;

public Status() {

}


public void setOffen(){
    this.status = "Offen";
    this.isOffen = true;
}
public void setAusstehend(){
    this.status = "Ausstehend";
    this.isAusstehend = true;
}
public void setBezahlt(){
    this.status = "Bezahlt";
    this.isBezahlt = true;
}
}
