package com.webapp.student;

import lombok.Data;

@Data
public class SubjectResponseDTO {
    private Long id;
    private String name;
    private StandardDTO standard;
    private TeacherDTO teacher;
}

//@Data
//public class StandardDTO {
//    private Long id;
//    private String name;
//}
//
//@Data
//public class TeacherDTO {
//    private Long id;
//    private String name;
//}
