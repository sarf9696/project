package ir.fanap.mehdisarfejoo.project.factory;

import ir.fanap.mehdisarfejoo.project.entity.device.SmartPhone;
import ir.fanap.mehdisarfejoo.project.entity.device.Tablet;
import ir.fanap.mehdisarfejoo.project.entity.device.Phone;
import ir.fanap.mehdisarfejoo.project.entity.simcard.HamraheAvalSIMCard;
import ir.fanap.mehdisarfejoo.project.entity.simcard.IrancellSIMCard;
import ir.fanap.mehdisarfejoo.project.entity.simcard.RightelSIMCard;

public class ObjectFactory {

    public Phone getBean(String phoneType, String simCardOperator) {

        if (phoneType.equals(PhoneType.SMART_PHONE.toString()) && simCardOperator.equals("HAMRAHAVAL")) {

            return new SmartPhone(new HamraheAvalSIMCard());

        } else if (phoneType.equals(PhoneType.SMART_PHONE.toString()) && simCardOperator.equals("IRANCELL")) {

            return new SmartPhone(new IrancellSIMCard());

        } else if (phoneType.equals(PhoneType.SMART_PHONE.toString()) && simCardOperator.equals("RIGHTEL")) {

            return new SmartPhone(new RightelSIMCard());

        } else if (phoneType.equals(PhoneType.TABLET.toString()) && simCardOperator.equals("HAMRAHAVAL")) {

            return new Tablet(new HamraheAvalSIMCard());

        } else if (phoneType.equals(PhoneType.TABLET.toString()) && simCardOperator.equals("IRANCELL")) {

            return new Tablet(new IrancellSIMCard());

        } else if (phoneType.equals(PhoneType.TABLET.toString()) && simCardOperator.equals("RIGHTEL")) {

            return new Tablet(new RightelSIMCard());
        }

        return null;
    }
}

enum PhoneType {

    SMART_PHONE("SmartPhone"), TABLET("Tablet");

    private final String name;

    private PhoneType(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

