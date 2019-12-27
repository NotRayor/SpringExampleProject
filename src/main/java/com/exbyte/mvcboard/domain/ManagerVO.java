package com.exbyte.mvcboard.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class ManagerVO {
    @NonNull String id;
    @NonNull String password;
    @NonNull String name;
}
