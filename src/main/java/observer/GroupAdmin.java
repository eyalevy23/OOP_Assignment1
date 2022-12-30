package observer;

import java.util.*;

public class GroupAdmin implements Sender {

    private ArrayList<Member> membersList;
    private UndoableStringBuilder usb;

    public GroupAdmin() {
        this.membersList = new ArrayList<Member>();
        this.usb = new UndoableStringBuilder();
    }

    //get the last usb update
    public String getUsbValue(){
        return usb.toString();
    }

    //new member register
    @Override
    public void register(Member member) {
        if(!membersList.contains(member)){
            membersList.add(member);
        }
    }

    //unregister current member
    @Override
    public void unregister(Member member) {
        // remove by obj
        membersList.remove(member);
    }

    //insert string to usb from index (int offset)
    @Override
    public void insert(int offset, String obj) {
        try {
            usb.insert(offset, obj);
        }
        catch (Exception e){
            //index out of bounds
        }
        updateSubscribers();
    }

    //add string to usb
    @Override
    public void append(String obj) {
        usb.append(obj);
        updateSubscribers();
    }

    //delete from usb from index start to index end
    @Override
    public void delete(int start, int end) {
        try{
            usb.delete(start, end);
        }
        catch (Exception e){
            //index out of bounds
        }
        updateSubscribers();
    }

    //undo to last update
    @Override
    public void undo() {
        usb.undo();
        updateSubscribers();
    }

    // after each action - insert, append etc...  need to call this method
    //in order of update the member by the latest update to usb
    void updateSubscribers() {
        for (Member member : membersList) {
            member.update(usb);
        }
    }

    public int getAmountOfMember(){
        return membersList.size();
    }

}
