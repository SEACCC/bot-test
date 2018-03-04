
public abstract class RequestParameters {

    private int version;

    @PathParam(CommonParams.PARAM_ID)
    private Long id;

    @HeaderParam(CommonParams.PARAM_MATCH)
    private String match;

    @HeaderParam(CommonParams.PARAM_NONE_MATCH)
    private String noneMatch;

                   for (const line in adds_line) {
                    if (adds_line.hasOwnProperty(line)) {
                        const reValue = /(\w+)/g;
                        let values = adds_line[line].match(reValue);
                        if (values) identifiers = identifiers.concat(values);
                    }
                }sion = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String getNoneMatch() {
        return noneMatch;
    }

    public void setNoneMatch(String noneMatch) {
        this.noneMatch = noneMatch;
    }

    /**
     * Validates the id string if it matches basic UUID format. Throws
     * NotFoundException if not valid.
     * 
     * @throws WebApplicationException
     */
    public void validateId() throws WebApplicationException {

        if (id == null) {
            throw WebException.notFound()
                    .message(CommonParams.ERROR_INVALID_ID).build();
        }
    }

    /**
     * Validates the If-Match and If-None-Match header content for tag format.
     * Throws a BadRequestException if not valid.
     * 
     * @throws WebApplicationException
     */
    public void validateTag() throws WebApplicationException {

        if (match != null) {
            validateTag(match);
        }

        if (noneMatch != null) {
            validateTag(noneMatch);
        }
    }

    /**
     * Validates the content and format of the parameters. Throws
     * BadRequestException if not valid.
     * 
     * Subclasses also need also to validate fields of the base class (except
     * resource id) that they are using.
     * 
     * @throws WebApplicationException
     */
    public abstract void validateParameters() throws WebApplicationException;

    /**
     * Updates the parameters of the internal version to the current one.
     */
    public abstract void update();

}
