package com.kicklance.fursaty.models;


import java.util.List;

public class Job {
    private final int id;
    private final String title;
    private final List<String> skills;
    private final String jobValidUntil;
    private final String summary;
    private final Country country;
    private final String experienceYears;
    private final boolean isFavorite;
    private final String createTime;
    private final int expireDate;
    private final int watchesCount;
    private final WorkField workField;
    private final String salary;
    private final BusinessMan businessMan;

    public Job(int id,
               String title,
               List<String> skills,
               String jobValidUntil,
               String summary,
               Country country,
               String experienceYears,
               boolean isFavorite,
               String createTime,
               int expireDate,
               int watchesCount,
               WorkField workField,
               String salary,
               BusinessMan businessMan) {
        this.id = id;
        this.title = title;
        this.skills = skills;
        this.jobValidUntil = jobValidUntil;
        this.summary = summary;
        this.country = country;
        this.experienceYears = experienceYears;
        this.isFavorite = isFavorite;
        this.createTime = createTime;
        this.expireDate = expireDate;
        this.watchesCount = watchesCount;
        this.workField = workField;
        this.salary = salary;
        this.businessMan = businessMan;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getSkills() {
        return skills;
    }

    public String getJobValidUntil() {
        return jobValidUntil;
    }

    public String getSummary() {
        return summary;
    }

    public Country getCountryOfEmployment() {
        return country;
    }

    public String getExperienceYears() {
        return experienceYears;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public String getCreateTime() {
        return createTime;
    }

    public int getExpireDate() {
        return expireDate;
    }

    public int getWatchesCount() {
        return watchesCount;
    }

    public WorkField getWorkField() {
        return workField;
    }

    public String getSalary() {
        return salary;
    }

    public BusinessMan getBusinessMan() {
        return businessMan;
    }

    public static class Country {
        private final int id;
        private final String code;
        private final String prefixNumber;
        private final String countryImage;
        private final String name;

        public Country(int id, String code, String prefixNumber, String countryImage, String name) {
            this.id = id;
            this.code = code;
            this.prefixNumber = prefixNumber;
            this.countryImage = countryImage;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getCode() {
            return code;
        }

        public String getPrefixNumber() {
            return prefixNumber;
        }

        public String getCountryImage() {
            return countryImage;
        }

        public String getName() {
            return name;
        }
    }

    public static class WorkField {
        private final int id;
        private final String name;

        public WorkField(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class BusinessMan {
        private final int id;
        private final String name;
        private final int employeeNo;
        private final String typeBusiness;
        private final String bio;
        private final String imageUrl;
        private final String coverUrl;
        private final int countryId;

        public BusinessMan(int id, String name, int employeeNo, String typeBusiness,
                           String bio, String imageUrl, String coverUrl, int countryId) {
            this.id = id;
            this.name = name;
            this.employeeNo = employeeNo;
            this.typeBusiness = typeBusiness;
            this.bio = bio;
            this.imageUrl = imageUrl;
            this.coverUrl = coverUrl;
            this.countryId = countryId;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getEmployeeNo() {
            return employeeNo;
        }

        public String getTypeBusiness() {
            return typeBusiness;
        }

        public String getBio() {
            return bio;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public String getCoverUrl() {
            return coverUrl;
        }

        public int getCountryId() {
            return countryId;
        }
    }
}
