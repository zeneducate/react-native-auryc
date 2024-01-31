const {
  withProjectBuildGradle,
  withStringsXml,
} = require("@expo/config-plugins");

module.exports = function withAndroidMavenAuryc(config, props = {}) {
  config = withProjectBuildGradle(config, (config) => {
    var aurycSDKPath = "https://bintray.auryc.com/repository/android-sdk/";

    if (!config.modResults.contents.includes(aurycSDKPath)) {
      config.modResults.contents += `
// @generated begin rn-auryc-sdk
allprojects { repositories { maven { url "${aurycSDKPath}" } } }
// @generated end rn-auryc-sdk
`;
    }

    return config;
  });

  config = withStringsXml(config, (config) => {
    if (!props.aurycToken || !props.aurycSiteId) {
      throw new Error("Please provide both aurycToken and aurycSiteId");
    }

    config.modResults.resources.string.push({
      $: { name: "auryc_token" },
      _: props.aurycToken,
    });
    config.modResults.resources.string.push({
      $: { name: "auryc_site_id" },
      _: props.aurycSiteId,
    });

    return config;
  });

  return config;
};
