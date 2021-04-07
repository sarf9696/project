package ir.fanap.mehdisarfejoo.project.dao;


import ir.fanap.mehdisarfejoo.project.entity.device.Phone;
import ir.fanap.mehdisarfejoo.project.entity.device.Tablet;
import ir.fanap.mehdisarfejoo.project.entity.simcard.RightelSIMCard;
import org.junit.*;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import static org.junit.Assert.*;

public class PhoneDAOTest {

    private static PhoneDAO phoneDAO;

    @BeforeClass
    public static void setUpClass() throws Exception {

        phoneDAO = new PhoneDAO();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {

        phoneDAO.closeFactory();
    }

    @Test
    public void create() {

        Tablet phone = new Tablet();
        phone.setType("tablet");

        RightelSIMCard simCard = new RightelSIMCard();
        simCard.setNumber("9386664444");
        phone.setSimCard(simCard);

        Phone savedPhone = phoneDAO.create(phone);

        Assert.assertTrue(savedPhone.getId() > 0);
    }

    @Test
    public void update() {


        Tablet phone = new Tablet();
        phone.setId(2);
        phone.setType("tablet");

        RightelSIMCard simCard = new RightelSIMCard();
        simCard.setNumber("938666000");
        phone.setSimCard(simCard);

        Phone updatedPhone = phoneDAO.update(phone);

        assertEquals(2, updatedPhone.getSimCard().getNumber());
    }

    @Test
    public void get() {

        int phoneId = 2;

        Phone retrievedPhone = phoneDAO.get(phoneId);

        System.out.println(retrievedPhone.getId());
        assertNotNull(retrievedPhone);
    }

    @Test
    public void delete() {

        int id = 2;
        phoneDAO.delete(id);
        assertNull(phoneDAO.get(id));
    }

    @Test(expected = EntityNotFoundException.class)
    public void deleteNotExistPhone() {

        int id = 78788;
        phoneDAO.delete(id);
    }

    @Test
    public void listAll() {
        List<Phone> phones = phoneDAO.listAll();

        assertTrue(phones.size() > 0);

        for (Phone phone : phones) {
            System.out.println(phone.getId());
        }
    }

    @Test
    public void count() {
        long count = phoneDAO.count();
        assertEquals(2, count);
    }

    @Test
    public void findByNumber() {

        Phone phone = phoneDAO.findByNumber("41544");

        System.out.println(phone.getSimCard().getBalance());
    }
}