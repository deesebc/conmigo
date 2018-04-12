package com.conmigo.app.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class UserDto extends GenericDto<Long> {

    private static final long serialVersionUID = 1L;

    protected Long id;
    protected ProvinceDto province;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String username;
    protected String password;
    protected boolean enable;
    protected LocalDate birthdate;
    protected String town;
    protected String gender;
    protected Set<RoleDto> roles = new HashSet<>(0);

    public UserDto() {
        super();
    }

    public UserDto(final Long id) {
        super();
        this.id = id;
    }

    public UserDto(final long createdBy, final LocalDateTime createdDate) {
        super();
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public UserDto(final ProvinceDto province, final String firstName, final String lastName, final String email,
            final String username, final String password, final Boolean enable, final long createdBy,
            final LocalDateTime createdDate, final Long lastModifiedBy, final LocalDateTime lastModifiedDate,
            final Set<RoleDto> roles) {
        this.province = province;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.enable = enable;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
        this.roles = roles;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(final boolean enable) {
        this.enable = enable;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(final LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getTown() {
        return town;
    }

    public void setTown(final String town) {
        this.town = town;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    /**
     * @return Valor de la propiedad roles
     */
    public Set<RoleDto> getRoles() {
        return roles;
    }

    /**
     * @param roles
     *            Valor de la propiedad roles a setear
     */
    public void setRoles(final Set<RoleDto> roles) {
        this.roles = roles;
    }

    public ProvinceDto getProvince() {
        return province;
    }

    public void setProvince(final ProvinceDto province) {
        this.province = province;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (id == null ? 0 : id.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof UserDto)) {
            return false;
        }
        UserDto other = (UserDto) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
