package io.datadynamics.projects.oauth2.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {

    String username;


    String name;

    String password;

}
