package ir.fanap.mehdisarfejoo.project.dao;

import ir.fanap.mehdisarfejoo.project.entity.device.Phone;

import java.util.List;

public class PhoneDAO extends ParentDAO<Phone> implements GenericDAO<Phone> {

    @Override
    public Phone create(Phone phone) {
        return super.create(phone);
    }

    @Override
    public Phone update(Phone phone) {
        return super.update(phone);
    }

    @Override
    public Phone get(Object id) {
        return super.find(Phone.class, id);
    }

    @Override
    public void delete(Object id) {
        super.delete(Phone.class, id);
    }

    public Phone findByNumber(String number){

        List<Phone> phones = super.findWithNamedQuery("Phone.findByNumber", "number", number);

        if (phones != null && phones.size() == 1)
            return phones.get(0);

        return null;
    }

    @Override
    public List<Phone> listAll() {
        return super.findWithNamedQuery("Phone.findAll");
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Phone.countAll");
    }
}
