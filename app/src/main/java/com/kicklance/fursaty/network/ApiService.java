package com.kicklance.fursaty.network;


import com.kicklance.fursaty.models.FAQ;
import com.kicklance.fursaty.models.Job;
import com.kicklance.fursaty.models.ResponseData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @GET("job-seeker/all-jobs")
    Call<ResponseData<List<Job>>> getAllJobs();

    @GET("job-seeker/job-details/{id}")
    Call<ResponseData<Job>> getJobDetails(@Path("id") int jobId);

    @GET("job-seeker/favorite-jobs")
    Call<ResponseData<List<Job>>> getFavoriteJobs(@Header("Authorization") String token);

    @POST("job-seeker/jobs/{id}/mark-favorite")
    Call<ResponseData<Void>> addFavoriteJob(
            @Header("Authorization") String token,
            @Path("id") int jobId
    );

    @GET("faqs")
    Call<ResponseData<List<FAQ>>> getFaqs();

    @GET("policies")
    Call<ResponseData<FAQ>> getPrivacyPolicy();

}
