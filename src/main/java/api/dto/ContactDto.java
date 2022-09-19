package api.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class ContactDto {

    String address;
    String description;
    String email;
    int id;
    String lastName;
    String name;
    String phone;
}
