package com.br.findYourPet;

import com.br.findYourPet.enumerators.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class RequestResponse<T> {

    private final Status status;

    private final String statusMessage;

    private final T content;

    public RequestResponse(final Status status, final String statusMessage, final T content) {
        this.status = status;
        this.statusMessage = statusMessage;
        this.content = content;
    }

    public static <T> RequestResponse<T> ok(final T content) {
        return new RequestResponse<>(Status.OK, null, content);
    }

    public static <T> RequestResponse<T> error(final String statusMessage) {
        return new RequestResponse<>(Status.ERROR, statusMessage, null);
    }

    public static <T> RequestResponse<T> errorWithContent(final String statusMessage, final T content) {
        return new RequestResponse<>(Status.ERROR, statusMessage, content);
    }

}
