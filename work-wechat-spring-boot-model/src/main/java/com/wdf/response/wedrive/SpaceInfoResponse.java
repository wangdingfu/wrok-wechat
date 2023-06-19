package com.wdf.response.wedrive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.dto.wedrive.SpaceInfo;
import com.wdf.response.AbstractBaseResponse;

/**
 * @author ddshuai
 * date 2022-09-01 22:51
 **/
public class SpaceInfoResponse extends AbstractBaseResponse {

    @JsonProperty(value = "space_info")
    private SpaceInfo spaceInfo;

    public SpaceInfo getSpaceInfo() {
        return spaceInfo;
    }

    public void setSpaceInfo(SpaceInfo spaceInfo) {
        this.spaceInfo = spaceInfo;
    }
}
