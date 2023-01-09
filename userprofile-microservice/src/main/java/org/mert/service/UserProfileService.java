package org.mert.service;


import org.mert.exception.ErrorType;
import org.mert.exception.UserProfileMicroserviceExecption;
import org.mert.repository.UserProfileRepository;
import org.mert.repository.entity.UserProfile;
import org.mert.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile,Long> {

    private final UserProfileRepository userProfileRepository;


    public List<UserProfile> findAll(Long userid) {

        Optional<UserProfile> userProfile = userProfileRepository.findOptionalByAuthid(userid);
        if (userProfile.isEmpty())
            throw new UserProfileMicroserviceExecption(ErrorType.UNAUTHORIZED_REQUEST);
        return findAll();
    }

    public UserProfileService(UserProfileRepository userProfileRepository) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
    }
}
