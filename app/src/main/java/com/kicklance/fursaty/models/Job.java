package com.kicklance.fursaty.models;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;

public class Job implements Parcelable {
    public static final Creator<Job> CREATOR = new Creator<>() {
        @Override
        public Job createFromParcel(Parcel in) {
            return new Job(in);
        }

        @Override
        public Job[] newArray(int size) {
            return new Job[size];
        }
    };
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

    protected Job(Parcel in) {
        id = in.readInt();
        title = in.readString();
        skills = in.createStringArrayList();
        jobValidUntil = in.readString();
        summary = in.readString();
        country = in.readParcelable(Country.class.getClassLoader());
        experienceYears = in.readString();
        isFavorite = in.readByte() != 0;
        createTime = in.readString();
        expireDate = in.readInt();
        watchesCount = in.readInt();
        workField = in.readParcelable(WorkField.class.getClassLoader());
        salary = in.readString();
        businessMan = in.readParcelable(BusinessMan.class.getClassLoader());
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeStringList(skills);
        parcel.writeString(jobValidUntil);
        parcel.writeString(summary);
        parcel.writeParcelable(country, i);
        parcel.writeString(experienceYears);
        parcel.writeByte((byte) (isFavorite ? 1 : 0));
        parcel.writeString(createTime);
        parcel.writeInt(expireDate);
        parcel.writeInt(watchesCount);
        parcel.writeParcelable(workField, i);
        parcel.writeString(salary);
        parcel.writeParcelable(businessMan, i);
    }

    public static class Country implements Parcelable {
        public static final Creator<Country> CREATOR = new Creator<>() {
            @Override
            public Country createFromParcel(Parcel in) {
                return new Country(in);
            }

            @Override
            public Country[] newArray(int size) {
                return new Country[size];
            }
        };
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

        protected Country(Parcel in) {
            id = in.readInt();
            code = in.readString();
            prefixNumber = in.readString();
            countryImage = in.readString();
            name = in.readString();
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            parcel.writeInt(id);
            parcel.writeString(code);
            parcel.writeString(prefixNumber);
            parcel.writeString(countryImage);
            parcel.writeString(name);
        }
    }

    public static class WorkField implements Parcelable {
        public static final Creator<WorkField> CREATOR = new Creator<>() {
            @Override
            public WorkField createFromParcel(Parcel in) {
                return new WorkField(in);
            }

            @Override
            public WorkField[] newArray(int size) {
                return new WorkField[size];
            }
        };
        private final int id;
        private final String name;

        public WorkField(int id, String name) {
            this.id = id;
            this.name = name;
        }

        protected WorkField(Parcel in) {
            id = in.readInt();
            name = in.readString();
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            parcel.writeInt(id);
            parcel.writeString(name);
        }
    }

    public static class BusinessMan implements Parcelable {
        public static final Creator<BusinessMan> CREATOR = new Creator<>() {
            @Override
            public BusinessMan createFromParcel(Parcel in) {
                return new BusinessMan(in);
            }

            @Override
            public BusinessMan[] newArray(int size) {
                return new BusinessMan[size];
            }
        };
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

        protected BusinessMan(Parcel in) {
            id = in.readInt();
            name = in.readString();
            employeeNo = in.readInt();
            typeBusiness = in.readString();
            bio = in.readString();
            imageUrl = in.readString();
            coverUrl = in.readString();
            countryId = in.readInt();
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            parcel.writeInt(id);
            parcel.writeString(name);
            parcel.writeInt(employeeNo);
            parcel.writeString(typeBusiness);
            parcel.writeString(bio);
            parcel.writeString(imageUrl);
            parcel.writeString(coverUrl);
            parcel.writeInt(countryId);
        }
    }
}
