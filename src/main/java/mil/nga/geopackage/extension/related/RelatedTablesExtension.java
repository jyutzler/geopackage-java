package mil.nga.geopackage.extension.related;

import java.util.ArrayList;
import java.util.List;

import mil.nga.geopackage.GeoPackage;
import mil.nga.geopackage.GeoPackageException;
import mil.nga.geopackage.db.GeoPackageConnection;
import mil.nga.geopackage.extension.related.media.MediaDao;
import mil.nga.geopackage.extension.related.media.MediaTable;
import mil.nga.geopackage.user.custom.UserCustomColumn;
import mil.nga.geopackage.user.custom.UserCustomDao;
import mil.nga.geopackage.user.custom.UserCustomResultSet;
import mil.nga.geopackage.user.custom.UserCustomTable;
import mil.nga.geopackage.user.custom.UserCustomTableReader;

/**
 * Related Tables extension
 * 
 * @author jyutzler
 * @since 3.0.1
 */
public class RelatedTablesExtension extends RelatedTablesCoreExtension {

	/**
	 * GeoPackage connection
	 */
	private GeoPackageConnection connection;

	/**
	 * Constructor
	 * 
	 * @param geoPackage
	 *            GeoPackage
	 * 
	 */
	public RelatedTablesExtension(GeoPackage geoPackage) {
		super(geoPackage);
		connection = geoPackage.getConnection();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPrimaryKeyColumnName(String tableName) {
		UserCustomTable table = UserCustomTableReader.readTable(connection,
				tableName);
		UserCustomColumn pkColumn = table.getPkColumn();
		if (pkColumn == null) {
			throw new GeoPackageException("Found no primary key for table "
					+ tableName);
		}
		return pkColumn.getName();
	}

	/**
	 * Get a User Custom DAO from a table name
	 * 
	 * @param tableName
	 *            table name
	 * @return user custom dao
	 */
	public UserCustomDao getUserDao(String tableName) {
		return UserCustomDao.readTable(getGeoPackage().getName(), connection,
				tableName);
	}

	/**
	 * Get a User Mapping DAO from an extended relation
	 * 
	 * @param extendedRelation
	 *            extended relation
	 * @return user mapping dao
	 */
	public UserMappingDao getMappingDao(ExtendedRelation extendedRelation) {
		return getMappingDao(extendedRelation.getMappingTableName());
	}

	/**
	 * Get a User Mapping DAO from a table name
	 * 
	 * @param tableName
	 *            mapping table name
	 * @return user mapping dao
	 */
	public UserMappingDao getMappingDao(String tableName) {
		return new UserMappingDao(getUserDao(tableName));
	}

	/**
	 * Get a related media table DAO
	 * 
	 * @param mediaTable
	 *            media table
	 * @return media DAO
	 */
	public MediaDao getMediaDao(MediaTable mediaTable) {
		return getMediaDao(mediaTable.getTableName());
	}

	/**
	 * Get a related media table DAO
	 * 
	 * @param extendedRelation
	 *            extended relation
	 * @return media DAO
	 */
	public MediaDao getMediaDao(ExtendedRelation extendedRelation) {
		return getMediaDao(extendedRelation.getRelatedTableName());
	}

	/**
	 * Get a related media table DAO
	 * 
	 * @param tableName
	 *            media table name
	 * @return media DAO
	 */
	public MediaDao getMediaDao(String tableName) {
		MediaDao mediaDao = new MediaDao(getUserDao(tableName));
		setContents(mediaDao.getTable());
		return mediaDao;
	}

	/**
	 * Get the related id mappings for the base id
	 * 
	 * @param extendedRelation
	 *            extended relation
	 * @param baseId
	 *            base id
	 * @return IDs representing the matching related IDs
	 */
	public List<Long> getMappingsForBase(ExtendedRelation extendedRelation,
			long baseId) {
		return getMappingsForBase(extendedRelation.getMappingTableName(),
				baseId);
	}

	/**
	 * Get the related id mappings for the base id
	 * 
	 * @param tableName
	 *            mapping table name
	 * @param baseId
	 *            base id
	 * @return IDs representing the matching related IDs
	 */
	public List<Long> getMappingsForBase(String tableName, long baseId) {

		List<Long> relatedIds = new ArrayList<>();

		UserMappingDao userMappingDao = getMappingDao(tableName);
		UserCustomResultSet resultSet = userMappingDao.queryByBaseId(baseId);
		try {
			while (resultSet.moveToNext()) {
				UserMappingRow row = userMappingDao.getRow(resultSet);
				relatedIds.add(row.getRelatedId());
			}
		} finally {
			resultSet.close();
		}

		return relatedIds;
	}

	/**
	 * Get the base id mappings for the related id
	 * 
	 * @param extendedRelation
	 *            extended relation
	 * @param relatedId
	 *            related id
	 * @return IDs representing the matching base IDs
	 */
	public List<Long> getMappingsForRelated(ExtendedRelation extendedRelation,
			long relatedId) {
		return getMappingsForRelated(extendedRelation.getMappingTableName(),
				relatedId);
	}

	/**
	 * Get the base id mappings for the related id
	 * 
	 * @param tableName
	 *            mapping table name
	 * @param relatedId
	 *            related id
	 * @return IDs representing the matching base IDs
	 */
	public List<Long> getMappingsForRelated(String tableName, long relatedId) {

		List<Long> baseIds = new ArrayList<>();

		UserMappingDao userMappingDao = getMappingDao(tableName);
		UserCustomResultSet resultSet = userMappingDao
				.queryByRelatedId(relatedId);
		try {
			while (resultSet.moveToNext()) {
				UserMappingRow row = userMappingDao.getRow(resultSet);
				baseIds.add(row.getBaseId());
			}
		} finally {
			resultSet.close();
		}

		return baseIds;
	}

}
