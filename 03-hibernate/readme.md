<h3>configuration file name</h3>
<ol>hibernate.cfg.xml</ol>
<ol>hibernate.properties</ol>


create table EMP (
       emp_id bigint not null auto_increment,
        city varchar(255),
        LandMARK varchar(255),
        STREET_NO varchar(255),
        zip varchar(255),
        DATE_OF_JOINING datetime,
        name varchar(255),
        salary double precision,
        primary key (emp_id)
    ); 
    
    create table EMP_USER (
       userId bigint not null auto_increment,
        city varchar(255),
        LandMARK varchar(255),
        STREET_NO varchar(255),
        zip varchar(255),
        CREATED datetime not null,
        CREATED_BY varchar(255) not null,
        doj datetime,
        email varchar(255),
        LAST_UPDATED datetime,
        LAST_UPDATED_BY varchar(255),
        name varchar(255) not null,
        primary key (userId)
    ) engine=MyISAM
    
    
    
    
    
        @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="startDate",
                               column=@Column("EMP_START")),
            @AttributeOverride(name="endDate",
                               column=@Column("EMP_END"))
    })
    public EmploymentPeriod getEmploymentPeriod() { ... }

 