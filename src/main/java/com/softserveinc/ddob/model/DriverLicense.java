package com.softserveinc.ddob.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@RequiredArgsConstructor
public class DriverLicense {
    private final String serialNumber;
    private final LocalDate dateOfIssue;
    private final LocalDate expirationDate;

    public boolean isNotExpired() {
        return !isExpired();
    }

    public boolean isExpired() {
        return expirationDate.isBefore(LocalDate.now());
    }
}
