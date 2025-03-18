package by.aston.livecoding.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {

//    У нас есть список организаций.
//    Внутри есть 3 поля: name, fullName и nn.
//    Нам необходимо составить такую Map, в которой ключем будет nn, а значением будет fullName.

    public static void main(String[] args) {
        final var organizations = List.of(
                new Organization("Org1", "Organization One", "001"),
                new Organization("Org2", "Organization Two", "002"),
                new Organization("Org3", "Organization Three", "003"),
                new Organization("Org4", "Organization Four", "004"),
                new Organization("Org5", "Organization Five", "005"),
                new Organization("Org6", "Organization Six", "006"),
                new Organization("Org7", "Organization Seven", "007"),
                new Organization("Org8", "Organization Eight", "008"),
                new Organization("Org9", "Organization Nine", "009"),
                new Organization("Org10", "Organization Ten", "001")
        );

        final var map = listToMap(organizations);

        System.out.println(map);
    }

    public static Map<String, String> listToMap(List<Organization> organizations) {
        return organizations.stream()
                .collect(Collectors.toMap(Organization::getNn, Organization::getFullName, (s, s2) -> s + s2));
    }

    public static Map<String, List<String>> listToMap2(List<Organization> organizations) {
        return organizations.stream()
                .collect(Collectors.groupingBy(Organization::getNn, Collectors.mapping(organization -> organization.getName(), Collectors.toList())));
    }

    public static class Organization {
        private String name;
        private String fullName;
        private String nn;

        public Organization(String name, String fullName, String nn) {
            this.name = name;
            this.fullName = fullName;
            this.nn = nn;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getNn() {
            return nn;
        }

        public void setNn(String nn) {
            this.nn = nn;
        }
    }
}