package com.tanguydev.ismb.Infrastructure.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainUe;
import com.tanguydev.ismb.Domain.Presenter.UePresenterInterface;
import com.tanguydev.ismb.Domain.Response.UeResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.UeMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UePresenter implements UePresenterInterface {

    private final UeMapper ueMapper;

    public UePresenter(UeMapper ueMapper) {
        this.ueMapper = ueMapper;
    }

    @Override
    public UeResponse present(DomainUe domainUe) {
        return ueMapper.toResponse(domainUe);
    }

    @Override
    public List<UeResponse> presentList(List<DomainUe> domainUes) {
        return domainUes.stream()
                .map(ueMapper::toResponse)
                .collect(Collectors.toList());
    }
}
