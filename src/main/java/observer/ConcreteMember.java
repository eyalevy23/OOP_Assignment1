package observer;

public class ConcreteMember implements Member {

    private UndoableStringBuilder lastUsb = null;

    private int id = 0;

    static int numberOfRegister = 0;

    public  ConcreteMember(){
        this.lastUsb = new UndoableStringBuilder();
        this.id = numberOfRegister;
        numberOfRegister++;
    }

    @Override
    public void update(UndoableStringBuilder usb) {
        lastUsb = usb;
    }

    public int getID(ConcreteMember cm){
        return cm.id;
    }

    public String getUsb(){
        return lastUsb.toString();
    }
    
}
