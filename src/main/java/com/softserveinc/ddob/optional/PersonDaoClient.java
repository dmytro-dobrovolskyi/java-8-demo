package com.softserveinc.ddob.optional;

import com.softserveinc.ddob.model.DriverLicense;
import com.softserveinc.ddob.model.Person;

import java.time.LocalDate;
import java.util.Optional;

public class PersonDaoClient {
    private PersonDao personDao;

    public DriverLicense getPersonDriverLicenseClassic(String name) {
        Person maybePerson = personDao.findByNameClassic(name);
        if (maybePerson != null) {
            DriverLicense driverLicense = maybePerson.getDriverLicense();
            if (driverLicense != null && driverLicense.isNotExpired()) {
                return driverLicense;
            }
        }
        return null;
    }

    public Optional<DriverLicense> getPersonDriverLicenseOptional(String name) {
        return personDao
                .findByNameOptional(name)
                .map(Person::getDriverLicense)
                .filter(DriverLicense::isNotExpired);
    }
    public static void main(String[] args) {
        PersonDaoClient personDaoClient = new PersonDaoClient();
        personDaoClient.personDao = new PersonDao() {
            @Override
            public Person findByNameClassic(String name) {
                return null;
            }

            @Override
            public Optional<Person> findByNameOptional(String name) {
                Person person = new Person("Dmytro", 20);
                person.setDriverLicense(new DriverLicense("42dfcsaf4353", LocalDate.now(), LocalDate.of(2018, 8, 17)));

                return Optional.of(person);
            }
        };

        personDaoClient
                .getPersonDriverLicenseOptional("Dmytro")
                .ifPresent(System.out::println);
    }
}
