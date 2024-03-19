package Utilities;

public enum APIEndpoints {
    //Vulnerabilities  //Bulk operation pending
    listVuln("vulnerabilities"),
    searchVuln("vulnerabilities/search"),
    validateSearch("vulnerabilities/validate_search"),
    showVuln("vulnerabilities/{id}"),
    showScannerVuln("vulnerabilities/{id}/scanner_vulnerabilities"),
    createVuln("vulnerabilities"),
    updateVuln("vulnerabilities/{id}"),
    bulkUpdateVulns("vulnerabilities/bulk"),
    deleteVuln("vulnerabilities/{id}"),
    bulkDeleteVulns("vulnerabilities/bulk_delete"),

    //Assets //Bulk operation pending
    listAssets("assets"),
    searchAssets("assets/search"),
    validateAssetSearch("assets/validate_search"),
    showAsset("assets/{id}"),
    createAsset("assets"),
    updateAsset("assets/{id}"),
    bulkUpdateAssets("assets/bulk"),
    showAssetVulns("assets/{id}/vulnerabilities"),

    //Asset Tagging
    listAssetTags("assets/{id}/tags"),
    tagAsset("assets/{id}/tags"),
    untagAsset("assets/{id}/tags"),

    //Asset groups //Needs data setup
    listAssetGroup("asset_groups"),
    showAssetGroup("asset_groups/{id}"),
    showAssetGroupFixes("asset_groups/{id}/fixes"),
    showAssetGroupTopFixes("asset_groups/{id}/top_fixes"),
    createAssetGroupRiskMeters("asset_groups"),
    updateAssetGroup("asset_groups/{id}"),
    deleteAssetGroup("asset_groups/{id}"),

    //Asset Group Reporting //Needs data setup
    historicalMTTR("asset_groups/{id}/report_query/historical_mean_time_to_remediate_by_risk_level"),
    historicalRiskMeterScores("/asset_groups/{id}/report_query/historical_risk_meter_scores"),
    historicalVulnRiskCategoryCounts("asset_groups/{id}/report_query/historical_open_vulnerability_count_by_risk_level"),
    vulnByDueDate("asset_groups/{id}/report_query/vulnerabilities_by_due_date"),
    totalPastDueVulns("asset_groups/{id}/report_query/total_past_due_vulnerabilities_by_risk_level"),
    avgDaysOpen("asset_groups/{id}/report_query/historical_avg_days_open_vulnerabilities_by_risk_level"),
    riskAccepted("asset_groups/{id}/report_query/risk_accepted_over_time"),
    falsePositive("asset_groups/{id/}report_query/historical_false_positives_by_risk_level"),
    pastDueVulnsByRiskLevel("asset_groups/{id}/report_query/historical_past_due_vulnerabilities_by_risk_level"),
    refreshReportingData("clients/refresh_reports"),
    getRefreshReportingStatus("clients/refresh_reports_status"),

    //Connectors
    connectorsList("connectors"),
    updateConnectors("connectors/{id}"),

    //ConnectorRuns //Pending update and run connector
    listConnectorRuns("connectors/{connector_id}/connector_runs"),
    showConnectorRun("connectors/{connector_id}/connector_runs/{connector_run_id}"),
    updateDataFile("connectors/{id}/data_file"),
    runConnector("connectors/{id}/run"),

    //Users
    listUsers("users"),
    showUser("users/{id}"),
    createUser("users"),
    updateUser("users/{id}"),
    deleteUser("users/{id}"),

    //Roles
    listRoles("roles"),
    showRole("roles/{id}"),
    createRole("roles"),
    updateRole("roles/{id}"),
    addAssetGroupToRole("roles/{id}/add_asset_groups"),
    addApplicationToRole("roles/{id}/add_applications"),
    deleteRole("roles/{id}"),
    updateRoleCustomPermissions("roles/{id}/custom_permissions"),

    //Fixes
    listFixes("fixes"),
    searchFixes("fixes/search"),
    showFix("fixes/{id}"),
    listAlternativeFixes("fixes/{id}/alternatives"),

    //Applications
    listApplications("applications"),
    showApplication("applications/{id}"),
    updateApplication("applications/{id}"),
    deleteApplication("applications/{id}"),
    createApplication("applications"),

    //Application Reporting //Needs data setup
    arHistoricalMTTR("applications/{id}/report_query/historical_mean_time_to_remediate_by_risk_level"),
    arHistoricalVulnRiskCategory("applications/{id}/report_query/historical_open_vulnerability_count_by_risk_level"),

    //Dashboard Groups (Views) //Needs data setup
    createDashboardGroup("dashboard_groups"),
    updateDashboardGroup("dashboard_groups/{id}"),
    showDashboardGroup("dashboard_groups/{id}"),
    listDashboardGroup("dashboard_groups"),
    deleteDashboardGroup("dashboard_groups/{id}"),

    //Data Export //?
    requestDataExport("data_exports"),
    retrieveDataExport("data_exports?search_id=search_id"),
    checkDataExportStatus("data_exports?status"),
    killDataExportStatus("data_exports/kill"),

    //CVES  //How to test?
    showCveHistory("vulnerability_definitions/history"),

    //Kenna.VI+ //How to test?
    showSingleVulnDef("vulnerability_definitions/{cve_id}"),
    listCveIdentifiers("vulnerability_definitions/cve_identifiers"),
    showVulnDefs("vulnerability_definitions"),
    showChatterData("vulnerability_definitions/{cve_id}/chatter"),

    //Inference //How to test?
    vulnInferenceApplications("vulnerability_definitions/app_inference"),
    vulnInferenceMSOs("vulnerability_definitions/os_inference");


    private final String resource;

    APIEndpoints(String resource)
    {
        this.resource=resource;
    }

    public String getResource()
    {
        return resource;
    }

}