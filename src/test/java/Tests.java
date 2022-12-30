import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import observer.Member;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);

// stub method to check external dependencies compatibility
//    logger.info(() -> JvmUtilities.objectFootprint(s1));
//    logger.info(() -> JvmUtilities.objectFootprint(s1, s2));
//    logger.info(() -> JvmUtilities.objectTotalSize(s1));
//    logger.info(() -> JvmUtilities.jvmInfo());
//    logger.info(() -> JvmUtilities.memoryStats(s1));


    @Test
    public void register(){
        GroupAdmin gr = new GroupAdmin();
        ConcreteMember cm1 = new ConcreteMember();
        gr.register(cm1);
        ConcreteMember cm2 = new ConcreteMember();
        gr.register(cm2);
        ConcreteMember cm3 = new ConcreteMember();
        gr.register(cm3);
        ConcreteMember cm4 = new ConcreteMember();
        gr.register(cm4);
        assertEquals(gr.getAmountOfMember(),4);
        gr.register(cm2);
        assertEquals(gr.getAmountOfMember(),4);
        logger.info(() -> JvmUtilities.memoryStats(gr));
    }

    @Test
    public void unregister(){
        GroupAdmin gr = new GroupAdmin();
        ConcreteMember cm1 = new ConcreteMember();
        gr.register(cm1);
        ConcreteMember cm2 = new ConcreteMember();
        gr.register(cm2);
        ConcreteMember cm3 = new ConcreteMember();
        gr.register(cm3);
        assertEquals(gr.getAmountOfMember(),3);
        gr.unregister(cm1);
        assertEquals(gr.getAmountOfMember(),2);
        gr.unregister(cm1);
    }

    @Test
    public void insert(){
        GroupAdmin gr = new GroupAdmin();
        ConcreteMember cm1 = new ConcreteMember();
        gr.register(cm1);
        ConcreteMember cm2 = new ConcreteMember();
        gr.register(cm2);
        gr.append("we ");
        gr.insert(3,"love");
        assertEquals(gr.getUsbValue(),cm1.getUsb());
        assertEquals(gr.getUsbValue(),cm2.getUsb());
        gr.insert(20, "coding");
    }

    @Test
    public void updateSubscribers(){
        GroupAdmin gr = new GroupAdmin();
        ConcreteMember cm1 = new ConcreteMember();
        gr.register(cm1);
        ConcreteMember cm2 = new ConcreteMember();
        gr.register(cm2);
        ConcreteMember cm3 = new ConcreteMember();
        gr.register(cm3);
        ConcreteMember cm4 = new ConcreteMember();
        gr.register(cm4);
        gr.append("this is a test");
        assertEquals(cm1.getUsb(), gr.getUsbValue());
        assertEquals(cm2.getUsb(), gr.getUsbValue());
        assertEquals(cm3.getUsb(), gr.getUsbValue());
        assertEquals(cm4.getUsb(), gr.getUsbValue());

    }

    @Test
    public void undo(){
        GroupAdmin gr = new GroupAdmin();
        gr.undo();
        ConcreteMember cm1 = new ConcreteMember();
        gr.register(cm1);
        gr.append("this is");
        gr.append("test");
        gr.undo();
        gr.append("a test");
        gr.undo();
        gr.undo();
        gr.undo();
        gr.undo();
    }

    @Test
    public void delete(){
        GroupAdmin gr = new GroupAdmin();
        ConcreteMember cm1 = new ConcreteMember();
        gr.register(cm1);
        ConcreteMember cm2 = new ConcreteMember();
        gr.register(cm2);
        gr.append("we love coding");
        gr.delete(3,8);
        assertEquals(gr.getUsbValue(),cm1.getUsb());
        assertEquals(gr.getUsbValue(),cm2.getUsb());
        assertEquals(gr.getUsbValue(),"we coding");
        gr.delete(3,40);
    }
}